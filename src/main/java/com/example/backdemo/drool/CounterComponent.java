package com.example.backdemo.drool;

import com.example.backdemo.entity.RiskRule;
import com.example.backdemo.entity.TradeInfo;
import org.drools.core.definitions.rule.impl.RuleImpl;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: superman
 * @create: 2020-02-10 10:44
 **/
@Component
public class CounterComponent {

    public boolean isExcess(TradeInfo tradeInfo, RiskRule riskRule, RuleImpl rule, RuleInfo ruleInfo) {

        boolean res = false;

        //通过ruleInfo获取对应的key值
        CounterAttribute counterAttribute = new CounterAttribute(tradeInfo, riskRule);

        //通过缓存获取对于的值
        Long currentValue = 0L;

        if (counterAttribute.getCounterTypeEnum() == null) {
            throw new RuntimeException("系统异常");
        }

        //先做自增操作  然后比较规则
        if (counterAttribute.getCounterTypeEnum() == CounterTypeEnum.MONEY) {
            currentValue = currentValue + tradeInfo.getAmount().longValue();
            res = DroolUtils.checkAmount(null, riskRule.getTradeLimitMoney(), currentValue);
        }

        if (counterAttribute.getCounterTypeEnum() == CounterTypeEnum.NUMS) {
            currentValue = currentValue + 1;
            res = DroolUtils.checkAmount(null, riskRule.getTradeLimitNums(), currentValue);
        }
        if (res) {
            DroolUtils.hit(rule, ruleInfo, tradeInfo, riskRule);
        }
        return res;
    }
}
