package com.example.backdemo.controller;
import java.time.LocalDateTime;
import java.math.BigDecimal;


import com.alibaba.fastjson.JSON;
import com.example.backdemo.common.BaseRes;
import com.example.backdemo.drool.RuleEventEnum;
import com.example.backdemo.drool.RuleInfo;
import com.example.backdemo.entity.RiskRule;
import com.example.backdemo.entity.TradeInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 风控规则表 前端控制器
 * </p>
 *
 * @author superman
 * @since 2020-02-06
 */
@RestController
@RequestMapping("/risk-rule")
@Slf4j
@Api(tags = "风控相关接口")
public class RiskRuleController {

    @Autowired
    private KieContainer kieContainer;

    @GetMapping("/testDrool")
    @ApiOperation("风控规则测试")
    public BaseRes testDrool() {
        RuleInfo ruleInfo = new RuleInfo();
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(ruleInfo);

        TradeInfo tradeInfo = new TradeInfo();
        tradeInfo.setId(0);
        tradeInfo.setPayerId(0);
        tradeInfo.setApplyNo("");
        tradeInfo.setCurrency("");
        tradeInfo.setAmount(new BigDecimal("10"));
        tradeInfo.setPayType(0);
        tradeInfo.setStatus(0);
        tradeInfo.setCreator("");
        tradeInfo.setUpdater("");
        tradeInfo.setDestinationAmount(new BigDecimal("0"));
        tradeInfo.setDestinationCurrency("");
        kieSession.insert(tradeInfo);

        RiskRule riskRule = new RiskRule();
        riskRule.setId(0);
        riskRule.setTaskId(0L);
        riskRule.setEvent("");
        riskRule.setPriority(0);
        riskRule.setCreateBy("");
        riskRule.setCreateTime(LocalDateTime.now());
        riskRule.setUpdateBy("");
        riskRule.setUpdateTime(LocalDateTime.now());
        riskRule.setIsDelete("");
        riskRule.setTimeSegment(0);
        riskRule.setTimeUnit("");
        riskRule.setTradeStartTime(LocalDateTime.now());
        riskRule.setTradeEndTime(LocalDateTime.now());
        riskRule.setTradeLimitNums(0);
        riskRule.setTradeLimitMoneyCurrency("");
        riskRule.setTradeLimitMoney(50);
        riskRule.setRegisterCountryIsoCode("");
        riskRule.setKycCountryIsoCode("");
        riskRule.setRuleStartTime(LocalDateTime.now());
        riskRule.setRuleEndTime(LocalDateTime.now());
        kieSession.insert(riskRule);

        int i = kieSession.fireAllRules();
        log.info("执行了{}条规则", i);
        log.info("-------------ruleInfo:{}------------", JSON.toJSONString(ruleInfo));
        kieSession.destroy();
        kieSession.dispose();
        return new BaseRes();

    }


//    @GetMapping("/testDrool1")
//    @ApiOperation("风控规则测试1")
//    public BaseRes testDrool1() {
//        Message message = new Message();
//        message.setMessage("Hello World");
//        message.setStatus(Message.HELLO);
//        KieSession kieSession = kieContainer.newKieSession();
//        kieSession.insert(message);
//        int i = kieSession.fireAllRules();
//        System.out.println("执行了"+i+"条规则");
//        System.out.println(JSON.toJSONString(message));
//        kieSession.destroy();
//        kieSession.dispose();
//        return new BaseRes();
//    }

    @GetMapping("/testDrool2")
    @ApiOperation("单人单日完成订单状态超过3笔")
    public BaseRes testDrool2() {
        RuleInfo ruleInfo = new RuleInfo();
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(ruleInfo);

        TradeInfo tradeInfo = new TradeInfo();
        tradeInfo.setId(0);
        tradeInfo.setPayerId(0);
        tradeInfo.setApplyNo("");
        tradeInfo.setCurrency("");
        tradeInfo.setAmount(new BigDecimal("10"));
        tradeInfo.setPayType(0);
        tradeInfo.setStatus(0);
        tradeInfo.setCreator("");
        tradeInfo.setUpdater("");
        tradeInfo.setDestinationAmount(new BigDecimal("0"));
        tradeInfo.setDestinationCurrency("");
        kieSession.insert(tradeInfo);

        RiskRule riskRule = new RiskRule();
        riskRule.setId(0);
        riskRule.setTaskId(0L);
        riskRule.setEvent(RuleEventEnum.SINGLE_DAY_LIMIT_MONEY.getCode());
        riskRule.setPriority(0);
        riskRule.setCreateBy("");
        riskRule.setCreateTime(LocalDateTime.now());
        riskRule.setUpdateBy("");
        riskRule.setUpdateTime(LocalDateTime.now());
        riskRule.setIsDelete("");
        riskRule.setTimeSegment(0);
        riskRule.setTimeUnit("");
        riskRule.setTradeStartTime(LocalDateTime.now());
        riskRule.setTradeEndTime(LocalDateTime.now());
        riskRule.setTradeLimitNums(0);
        riskRule.setTradeLimitMoneyCurrency("");
        riskRule.setTradeLimitMoney(50);
        riskRule.setRegisterCountryIsoCode("");
        riskRule.setKycCountryIsoCode("");
        riskRule.setRuleStartTime(LocalDateTime.now());
        riskRule.setRuleEndTime(LocalDateTime.now());
        kieSession.insert(riskRule);

        int i = kieSession.fireAllRules();
        log.info("执行了{}条规则", i);
        log.info("-------------ruleInfo:{}------------", JSON.toJSONString(ruleInfo));
        kieSession.destroy();
        kieSession.dispose();
        return new BaseRes();

    }

}
