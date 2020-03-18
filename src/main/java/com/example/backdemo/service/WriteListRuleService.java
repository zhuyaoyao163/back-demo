package com.example.backdemo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.backdemo.common.exception.HitRuleException;
import com.example.backdemo.common.exception.RiskException;
import com.example.backdemo.drool.RuleInfo;
import com.example.backdemo.drool.RuleTypeMappingEnum;
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
 * @description:
 * @author: superman
 * @create: 2020-02-14 18:29
 **/
@Service
@Slf4j
public class WriteListRuleService {

    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private ISenderInfoService senderInfoService;

    public RuleInfo fire(TradeInfo tradeInfo) {
        RuleInfo ruleInfo = new RuleInfo();

        KieSession kieSession = kieContainer.newKieSession();

        try {
            Map<String, Object> map = Maps.newHashMap();
            map.put("user_id", tradeInfo.getPayerId());
            QueryWrapper<SenderInfo> queryWrapper = new QueryWrapper();
            queryWrapper.allEq(map);
            List<SenderInfo> list = senderInfoService.list(queryWrapper);

            FactHandle ruleInfoHandle = kieSession.insert(ruleInfo);

            FactHandle tradeInfoHandle = kieSession.insert(tradeInfo);

            FactHandle senderInfoHandle = null;
            if (CollectionUtils.isEmpty(list)) {
                return ruleInfo;
            }
            for (SenderInfo senderInfo : list) {
                if (senderInfoHandle == null) {
                    senderInfoHandle = kieSession.insert(senderInfo);
                }else {
                    kieSession.update(senderInfoHandle, senderInfo);
                }
                AgendaFilter agendaFilter = new RuleNameStartsWithAgendaFilter(RuleTypeMappingEnum.WRITE_SENDER.getValue());
                kieSession.fireAllRules(agendaFilter);
                if (null != ruleInfo.getId()) {
                    break;
                }
            }
            if (null != senderInfoHandle) {
                kieSession.delete(senderInfoHandle);
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

    public boolean isWhite(TradeInfo tradeInfo) {
        try {
            RuleInfo fire = fire(tradeInfo);
        } catch (HitRuleException e) {
            return true;
        } catch (Exception e) {
            throw new RiskException("系统异常", e);
        }
        return false;
    }
}
