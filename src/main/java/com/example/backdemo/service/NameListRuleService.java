package com.example.backdemo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.backdemo.common.exception.HitRuleException;
import com.example.backdemo.common.exception.RiskException;
import com.example.backdemo.drool.NameListTypeEnum;
import com.example.backdemo.drool.RuleInfo;
import com.example.backdemo.drool.RuleTypeMappingEnum;
import com.example.backdemo.entity.PayeeInfo;
import com.example.backdemo.entity.RiskRule;
import com.example.backdemo.entity.SenderInfo;
import com.example.backdemo.entity.TradeInfo;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.drools.core.base.RuleNameStartsWithAgendaFilter;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.AgendaFilter;
import org.kie.api.runtime.rule.FactHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;

/**
 * @description: 黑白名单规则控制类
 * @author: superman
 * @create: 2020-02-10 16:29
 **/
@Service
@Slf4j
public class NameListRuleService implements BasicRuleService {

    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private ISenderInfoService senderInfoService;

    @Autowired
    private IPayeeInfoService payeeInfoService;

    @Override
    public RuleInfo fire(TradeInfo tradeInfo, RiskRule riskRule) {

        return null;
    }


    public RuleInfo fire(TradeInfo tradeInfo,NameListTypeEnum nameListTypeEnum) {

        RuleInfo ruleInfo = new RuleInfo();

        KieSession kieSession = kieContainer.newKieSession();
        try {
            FactHandle ruleInfoHandle = kieSession.insert(ruleInfo);

            FactHandle tradeInfoHandle = kieSession.insert(tradeInfo);

            Map<String, Object> map = Maps.newHashMap();
            map.put("user_id", tradeInfo.getPayerId());
            if (nameListTypeEnum == NameListTypeEnum.SENDER_BLACK_LIST) {

                QueryWrapper<SenderInfo> queryWrapper = new QueryWrapper();
                queryWrapper.allEq(map);
                List<SenderInfo> list = senderInfoService.list(queryWrapper);
                if (CollectionUtils.isEmpty(list)) {
                    return null;
                }
                FactHandle senderInfoHandle = null;
                for (SenderInfo senderInfo : list) {
                    if (senderInfoHandle == null) {
                        senderInfoHandle = kieSession.insert(senderInfo);
                    }else {
                        kieSession.update(senderInfoHandle, senderInfo);
                    }
                    AgendaFilter agendaFilter = new RuleNameStartsWithAgendaFilter(RuleTypeMappingEnum.BLACK_NAME_LIST.getValue());
                    kieSession.fireAllRules(agendaFilter);
                    if (null != ruleInfo.getId()) {
                        break;
                    }
                }
                if (null != senderInfoHandle) {
                    kieSession.delete(senderInfoHandle);
                }
            }else {
                QueryWrapper<PayeeInfo> queryWrapper = new QueryWrapper();
                queryWrapper.allEq(map);
                List<PayeeInfo> list = payeeInfoService.list(queryWrapper);
                if (CollectionUtils.isEmpty(list)) {
                    return null;
                }
                FactHandle payeeInfoInfoHandle = null;
                for (PayeeInfo payeeInfo : list) {
                    if (payeeInfoInfoHandle == null) {
                        payeeInfoInfoHandle = kieSession.insert(payeeInfo);
                    }else {
                        kieSession.update(payeeInfoInfoHandle, payeeInfo);
                    }
                    AgendaFilter agendaFilter = new RuleNameStartsWithAgendaFilter(RuleTypeMappingEnum.BLACK_NAME_LIST.getValue());
                    kieSession.fireAllRules(agendaFilter);
                    if (null != ruleInfo.getId()) {
                        break;
                    }
                }
                if (null != payeeInfoInfoHandle) {
                    kieSession.delete(payeeInfoInfoHandle);
                }
            }

            kieSession.delete(ruleInfoHandle);
            kieSession.delete(tradeInfoHandle);
            kieSession.dispose();
        } catch (Exception e) {
            throw new RiskException("系统异常", e);
        } finally {
            if (null != kieSession) {
                kieSession.dispose();
            }
        }
        if (null != ruleInfo.getId()) {
            throw new HitRuleException(ruleInfo);
        }
        return ruleInfo;
    }
}
