package com.example.backdemo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.backdemo.common.Constant;
import com.example.backdemo.common.exception.HitRuleException;
import com.example.backdemo.common.exception.RiskException;
import com.example.backdemo.drool.RiskResultEnum;
import com.example.backdemo.drool.RuleInfo;
import com.example.backdemo.drool.RuleTypeMappingEnum;
import com.example.backdemo.entity.RiskRecond;
import com.example.backdemo.entity.RiskRule;
import com.example.backdemo.entity.SenderInfo;
import com.example.backdemo.entity.TradeInfo;
import lombok.extern.slf4j.Slf4j;
import org.drools.core.base.RuleNameStartsWithAgendaFilter;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.AgendaFilter;
import org.kie.api.runtime.rule.FactHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @description: 用户唯一性
 * @author: superman
 * @create: 2020-03-03 18:11
 **/
@Service
@Slf4j
public class UserUniqueRuleService implements BasicRuleService{

    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private ISenderInfoService senderInfoService;

    @Autowired
    private IRiskRecondService riskRecondService;



    public RuleInfo fire(SenderInfo senderInfo) {
        log.info("用户唯一性检查  request:{}", senderInfo);
        if (senderInfo == null) {
            throw new RiskException(RiskResultEnum.PARAM_IS_ERROR);
        }
        RuleInfo ruleInfo = new RuleInfo();

        KieSession kieSession = kieContainer.newKieSession();

        try {
            FactHandle ruleInfoHandle = kieSession.insert(ruleInfo);
            FactHandle senderInfoHandle = kieSession.insert(senderInfo);
            QueryWrapper<SenderInfo> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("dob", senderInfo.getDob()).eq("register_country_iso_code", senderInfo.getKycCountryIsoCode())
                    .and(i -> i.eq("first_name", senderInfo.getFirstName()).or().eq("first_name", senderInfo.getLastName()))
                    .and(i -> i.eq("last_name", senderInfo.getFirstName()).or().eq("last_name", senderInfo.getLastName()));
            List<SenderInfo> list = senderInfoService.list(queryWrapper);
            kieSession.setGlobal("senderList", list);
//            FactHandle senderInfoHandle = kieSession.insert(list.get(0));
            AgendaFilter agendaFilter = new RuleNameStartsWithAgendaFilter(RuleTypeMappingEnum.USER_UNIQUE.getValue());
            int allRules = kieSession.fireAllRules(agendaFilter);
            log.info("命中了{}条规则", allRules);
            kieSession.delete(ruleInfoHandle);
            kieSession.delete(senderInfoHandle);
            kieSession.dispose();
        } catch (Exception e) {
            log.error("系统异常", e);
            throw new RiskException(RiskResultEnum.SYSTEM_ERROR);
        } finally {
            if (null != kieSession) {
                kieSession.dispose();
            }
        }
        if (null != ruleInfo.getId()) {
            RiskRecond riskRecond = new RiskRecond();
            riskRecond.setRuleId(0);
            riskRecond.setEvent(ruleInfo.getEvent());
            riskRecond.setUserId(senderInfo.getUserId());
            riskRecond.setIsDelete("0");
            riskRecond.setRiskLevel(ruleInfo.getRiskLevel());
            riskRecond.setCreateTime(LocalDateTime.now());
            riskRecond.setUpdateTime(LocalDateTime.now());
            riskRecondService.save(riskRecond);
            throw new HitRuleException(ruleInfo);
        }
        return ruleInfo;
    }

    @Override
    public RuleInfo fire(TradeInfo tradeInfo, RiskRule riskRule) {
        return null;
    }
}
