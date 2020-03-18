package com.example.backdemo.service;

import com.example.backdemo.common.exception.HitRuleException;
import com.example.backdemo.drool.CounterComponent;
import com.example.backdemo.drool.RuleInfo;
import com.example.backdemo.drool.RuleTypeMappingEnum;
import com.example.backdemo.entity.RiskRule;
import com.example.backdemo.entity.TradeInfo;
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

/**
 * @description:交易风控
 * @author: superman
 * @create: 2020-02-10 17:20
 **/
@Service
@Slf4j
public class TradeInfoRuleService implements BasicRuleService {

    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private CounterComponent counterComponent;

    @Autowired
    private WriteListRuleService writeListRuleService;

    @Override
    public RuleInfo fire(TradeInfo tradeInfo, RiskRule riskRule) {
        return null;
    }

    public RuleInfo fire(TradeInfo tradeInfo, List<RiskRule> riskRules, RuleTypeMappingEnum ruleTypeMappingEnum) {
        RuleInfo ruleInfo = new RuleInfo();
        if (!CollectionUtils.isEmpty(riskRules)) {
            for (RiskRule riskRule : riskRules) {
                try {
                    ruleInfo = fire(tradeInfo, riskRule, ruleTypeMappingEnum);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return ruleInfo;
    }

    public RuleInfo fire(TradeInfo tradeInfo, RiskRule riskRule, RuleTypeMappingEnum ruleTypeMappingEnum) {

        //白名单处理
        if (writeListRuleService.isWhite(tradeInfo)) {
            return new RuleInfo();
        }
        KieSession kieSession = kieContainer.newKieSession();
        RuleInfo ruleInfo = new RuleInfo();

        try {

            FactHandle ruleInfoHandle = kieSession.insert(ruleInfo);

            FactHandle tradeInfoHandle = kieSession.insert(tradeInfo);

            if (ruleTypeMappingEnum == RuleTypeMappingEnum.TRADE_STATISTICS) {
                kieSession.setGlobal("counterComponent", counterComponent);
            }
            FactHandle riskRuleHandle = kieSession.insert(riskRule);;
            AgendaFilter agendaFilter = new RuleNameStartsWithAgendaFilter(ruleTypeMappingEnum.getValue());
            int allRules = kieSession.fireAllRules(agendaFilter);
            log.info("命中了{}条规则", allRules);
//            for (RiskRule riskRule : riskRules) {
//                if (null != riskRuleHandle) {
//                    kieSession.update(riskRuleHandle, riskRule);
//                } else {
//                    riskRuleHandle = kieSession.insert(riskRule);
//                }
//                int allRules = kieSession.fireAllRules(agendaFilter);
//                log.info("命中了{}条规则", allRules);
//                if (null != ruleInfo.getId()) {
//                    break;
//                }
//            }
            if (null != riskRuleHandle) {
                kieSession.delete(riskRuleHandle);
            }
            kieSession.delete(ruleInfoHandle);
            kieSession.delete(tradeInfoHandle);
            kieSession.dispose();
        } catch (Exception e) {
            // TODO: 2020-02-10 抛出自定义异常
            e.printStackTrace();
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
