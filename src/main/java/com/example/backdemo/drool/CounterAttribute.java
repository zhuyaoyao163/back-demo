package com.example.backdemo.drool;

import com.example.backdemo.entity.RiskRule;
import com.example.backdemo.entity.TradeInfo;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.List;

/**
 * @description:
 * @author: superman
 * @create: 2020-02-10 11:03
 **/
public class CounterAttribute implements Serializable {

    private TradeInfo tradeInfo;

    private RiskRule riskRule;

    private CounterTypeEnum counterTypeEnum;

    private String counterKey;

    private static final String COUNTER_DELIMITER = "|";

    public CounterAttribute(TradeInfo tradeInfo, RiskRule riskRule) {
        this.tradeInfo = tradeInfo;
        this.riskRule = riskRule;
        this.counterTypeEnum = buildCounterTypeEnum(riskRule);
        this.counterKey = createKey();
    }

    public TradeInfo getTradeInfo() {
        return tradeInfo;
    }

    public void setTradeInfo(TradeInfo tradeInfo) {
        this.tradeInfo = tradeInfo;
    }

    public RiskRule getRiskRule() {
        return riskRule;
    }

    public void setRiskRule(RiskRule riskRule) {
        this.riskRule = riskRule;
    }

    public CounterTypeEnum getCounterTypeEnum() {
        return counterTypeEnum;
    }

    public void setCounterTypeEnum(CounterTypeEnum counterTypeEnum) {
        this.counterTypeEnum = counterTypeEnum;
    }

    public String getCounterKey() {
        return counterKey;
    }

    public void setCounterKey(String counterKey) {
        this.counterKey = counterKey;
    }

    private String createKey() {
        List<String> list = Lists.newArrayList();
        if (StringUtils.isNotEmpty(riskRule.getEvent())) {
            list.add(riskRule.getEvent());
        }
        if (tradeInfo.getPayerId() != null) {
            list.add(tradeInfo.getPayerId().toString());
        }
        if (CollectionUtils.isEmpty(list)) {
            throw new IllegalArgumentException("参数异常");
        }
        return StringUtils.join(list.toArray(), COUNTER_DELIMITER);
    }

    private CounterTypeEnum buildCounterTypeEnum(RiskRule riskRule) {
        if (riskRule == null || StringUtils.isEmpty(riskRule.getEvent())) {
            return null;
        }
        if (riskRule.getEvent().contains(CounterTypeEnum.NUMS.getType())) {
            return CounterTypeEnum.NUMS;
        } else if (riskRule.getEvent().contains(CounterTypeEnum.MONEY.getType())) {
            return counterTypeEnum.MONEY;
        }
        return null;
    }
}
