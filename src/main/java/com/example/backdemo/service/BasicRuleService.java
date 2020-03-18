package com.example.backdemo.service;

import com.example.backdemo.drool.RuleInfo;
import com.example.backdemo.entity.RiskRule;
import com.example.backdemo.entity.TradeInfo;

public interface BasicRuleService {

    public RuleInfo fire(TradeInfo tradeInfo, RiskRule riskRule);
}
