package com.example.backdemo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.backdemo.drool.RuleEventEnum;
import com.example.backdemo.drool.RuleInfo;
import com.example.backdemo.drool.RuleTypeMappingEnum;
import com.example.backdemo.entity.RiskRule;
import com.example.backdemo.entity.SenderInfo;
import com.example.backdemo.entity.TradeInfo;
import com.example.backdemo.service.CardInfoRuleService;
import com.example.backdemo.service.ISenderInfoService;
import com.example.backdemo.service.TradeInfoRuleService;
import com.example.backdemo.service.UserUniqueRuleService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
class RiskRuleControllerTest {

    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private TradeInfoRuleService tradeInfoRuleService;

    @Autowired
    private UserUniqueRuleService userUniqueRuleService;

    @Autowired
    private ISenderInfoService senderInfoService;

    @Autowired
    private CardInfoRuleService cardInfoRuleService;
    @Test
    void testDrool() {
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
    }

    @Test
    void testDrool1() {
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
        List<RiskRule> list = Lists.newArrayList(riskRule);
        RuleInfo ruleInfo = tradeInfoRuleService.fire(tradeInfo, list, RuleTypeMappingEnum.TRADE_SINGLE);
        log.info(JSON.toJSONString(ruleInfo));
    }


    @Test
    public void testDrool2() {

        TradeInfo tradeInfo = new TradeInfo();
        tradeInfo.setId(0);
        tradeInfo.setPayerId(0);
        tradeInfo.setApplyNo("2312312");
        tradeInfo.setCurrency("");
        tradeInfo.setAmount(new BigDecimal("10"));
        tradeInfo.setPayType(0);
        tradeInfo.setStatus(0);
        tradeInfo.setCreator("");
        tradeInfo.setUpdater("");
        tradeInfo.setDestinationAmount(new BigDecimal("0"));
        tradeInfo.setDestinationCurrency("");


        RiskRule riskRule = new RiskRule();
        riskRule.setId(0);
        riskRule.setTaskId(0L);
        riskRule.setEvent(RuleEventEnum.SINGLE_DAY_LIMIT_NUMS.getCode());
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


//        RiskRule riskRule1 = new RiskRule();
//        riskRule1.setId(0);
//        riskRule1.setTaskId(0L);
//        riskRule1.setEvent(RuleEventEnum.SINGLE_DAY_LIMIT_MONEY.getCode());
//        riskRule1.setPriority(0);
//        riskRule1.setCreateBy("");
//        riskRule1.setCreateTime(LocalDateTime.now());
//        riskRule1.setUpdateBy("");
//        riskRule1.setUpdateTime(LocalDateTime.now());
//        riskRule1.setIsDelete("");
//        riskRule1.setTimeSegment(0);
//        riskRule1.setTimeUnit("");
//        riskRule1.setTradeStartTime(LocalDateTime.now());
//        riskRule1.setTradeEndTime(LocalDateTime.now());
//        riskRule1.setTradeLimitNums(0);
//        riskRule1.setTradeLimitMoneyCurrency("");
//        riskRule1.setTradeLimitMoney(50);
//        riskRule1.setRegisterCountryIsoCode("");
//        riskRule1.setKycCountryIsoCode("");
//        riskRule1.setRuleStartTime(LocalDateTime.now());
//        riskRule1.setRuleEndTime(LocalDateTime.now());
//
//        ArrayList<RiskRule> riskRules = Lists.newArrayList();

        String str = "[{\"createBy\":\"admin\",\"createTime\":\"2020-02-24T08:59:19.665465000\",\"event\":\"SINGLE_ORDER_LIMIT_MIN_MONEY\",\"id\":1,\"isDelete\":\"0\",\"priority\":1,\"riskLevel\":0,\"taskId\":1,\"tradeLimitMoney\":100,\"updateBy\":\"admin\",\"updateTime\":\"2020-02-25T03:37:40.995519000\"},{\"createBy\":\"admin\",\"createTime\":\"2020-02-25T03:36:59.400932000\",\"event\":\"SINGLE_ORDER_LIMIT_MAX_MONEY\",\"id\":2,\"isDelete\":\"0\",\"priority\":1,\"riskLevel\":0,\"taskId\":2,\"tradeLimitMoney\":3000,\"updateTime\":\"2020-02-25T03:37:45.950101000\"},{\"createBy\":\"admin\",\"createTime\":\"2020-02-25T03:39:29.172494000\",\"event\":\"SINGLE_DAY_LIMIT_NUMS\",\"id\":3,\"isDelete\":\"0\",\"priority\":1,\"riskLevel\":2,\"taskId\":3,\"tradeLimitNums\":3,\"updateTime\":\"2020-02-25T03:54:31.174419000\"},{\"createBy\":\"admin\",\"createTime\":\"2020-02-25T03:40:21.649893000\",\"event\":\"SINGLE_DAY_LIMIT_MONEY\",\"id\":4,\"isDelete\":\"0\",\"priority\":1,\"riskLevel\":2,\"taskId\":4,\"tradeLimitMoney\":3000,\"updateTime\":\"2020-02-25T03:55:30.846943000\"},{\"createBy\":\"admin\",\"createTime\":\"2020-02-25T03:43:14.917749000\",\"event\":\"SINGLE_WEEKEND_LIMIT_NUMS\",\"id\":5,\"isDelete\":\"0\",\"priority\":1,\"riskLevel\":1,\"taskId\":1,\"tradeLimitNums\":99999,\"updateBy\":\"admin\",\"updateTime\":\"2020-02-25T03:56:26.073421000\"},{\"createBy\":\"admin\",\"createTime\":\"2020-02-25T03:43:19.781133000\",\"event\":\"SINGLE_WEEKEND_LIMIT_MONEY\",\"id\":6,\"isDelete\":\"0\",\"priority\":1,\"riskLevel\":1,\"taskId\":1,\"tradeLimitMoney\":10000,\"updateBy\":\"admin\",\"updateTime\":\"2020-02-25T03:56:22.216335000\"},{\"createBy\":\"admin\",\"createTime\":\"2020-02-25T03:43:24.704729000\",\"event\":\"SINGLE_MONTH_LIMIT_NUMS\",\"id\":7,\"isDelete\":\"0\",\"priority\":1,\"riskLevel\":1,\"taskId\":1,\"tradeLimitNums\":15,\"updateBy\":\"admin\",\"updateTime\":\"2020-02-25T03:56:19.154275000\"},{\"createBy\":\"admin\",\"createTime\":\"2020-02-25T03:43:30.279873000\",\"event\":\"SINGLE_MONTH_LIMIT_MONEY\",\"id\":8,\"isDelete\":\"0\",\"priority\":1,\"riskLevel\":1,\"taskId\":1,\"tradeLimitMoney\":50000,\"updateBy\":\"admin\",\"updateTime\":\"2020-02-25T03:56:15.894380000\"},{\"createBy\":\"admin\",\"createTime\":\"2020-02-25T03:43:38.642994000\",\"event\":\"SINGLE_YEAR_LIMIT_MONEY\",\"id\":9,\"isDelete\":\"0\",\"priority\":1,\"riskLevel\":1,\"taskId\":1,\"tradeLimitMoney\":999999,\"updateBy\":\"admin\",\"updateTime\":\"2020-02-25T03:56:01.806957000\"},{\"createBy\":\"admin\",\"createTime\":\"2020-02-25T03:43:43.228717000\",\"event\":\"SINGLE_YEAR_LIMIT_NUMS\",\"id\":10,\"isDelete\":\"0\",\"priority\":1,\"riskLevel\":1,\"taskId\":1,\"tradeLimitNums\":99999,\"updateBy\":\"admin\",\"updateTime\":\"2020-02-25T03:55:52.502192000\"},{\"createBy\":\"admin\",\"createTime\":\"2020-02-25T03:43:47.870613000\",\"event\":\"SINGLE_YEAR_CHINA_LIMIT_MONEY\",\"id\":11,\"isDelete\":\"0\",\"priority\":1,\"riskLevel\":3,\"taskId\":1,\"tradeLimitMoney\":50000,\"updateBy\":\"admin\",\"updateTime\":\"2020-02-25T03:55:48.697910000\"},{\"createBy\":\"admin\",\"createTime\":\"2020-02-25T03:43:56.005242000\",\"event\":\"TOTAL_LIMIT_MONEY\",\"id\":12,\"isDelete\":\"0\",\"priority\":1,\"riskLevel\":1,\"taskId\":1,\"tradeLimitMoney\":9999999,\"updateBy\":\"admin\",\"updateTime\":\"2020-02-25T03:56:33.001019000\"},{\"createBy\":\"admin\",\"createTime\":\"2020-02-25T03:44:01.001736000\",\"event\":\"TOTAL_LIMIT_NUMS\",\"id\":13,\"isDelete\":\"0\",\"priority\":1,\"riskLevel\":1,\"taskId\":1,\"tradeLimitNums\":99999,\"updateBy\":\"admin\",\"updateTime\":\"2020-02-25T18:01:25.010667000\"}]";
        List<RiskRule> riskRules = JSONArray.parseArray(str, RiskRule.class);
//        riskRules = riskRules.subList(2, 4);
//        riskRules.add(riskRule);
//        riskRules.add(riskRule1);
        //单笔交易规则
//        tradeInfoRuleService.fire(tradeInfo, riskRules, RuleTypeMappingEnum.TRADE_SINGLE);
        //单笔交易规则
        tradeInfoRuleService.fire(tradeInfo, riskRules, RuleTypeMappingEnum.TRADE_STATISTICS);
    }

    @Test
    public void testUniqueUser() {
        /**
         * SenderInfo(id=517, userId=819, dob=1987-03-03, fullAddress=北京市, documentType=1, issueDate=1984-03-05, expiryDate=2046-03-05, documentNumber=1234567890, mobile=null, registerCountryIsoCode=CHN, kycCountryIsoCode=CHN, email=yaoyaoz9@opera.com, firstName=yaoyao1, lastName=zhu, whiteFlag=0, blackFlag=null, blackDesc=null, createTime=2020-03-05T03:36:20, updateTime=2020-03-05T04:15:34.028)
         */
        SenderInfo senderInfo = new SenderInfo();
        senderInfo.setId(517);
        senderInfo.setUserId(819);
        senderInfo.setDob("1987-03-03");
        senderInfo.setFullAddress("北京市");
        senderInfo.setDocumentType("1");
        senderInfo.setIssueDate("1984-03-05");
        senderInfo.setExpiryDate("2046-03-05");
        senderInfo.setDocumentNumber("1234567890");
        senderInfo.setMobile("");
        senderInfo.setRegisterCountryIsoCode("CHN");
        senderInfo.setKycCountryIsoCode("CHN");
        senderInfo.setEmail("yaoyaoz9@opera.com");
        senderInfo.setFirstName("yaoyao11");
        senderInfo.setLastName("zhu");
        senderInfo.setWhiteFlag(0);
        senderInfo.setBlackFlag(0);
        senderInfo.setBlackDesc("");
        senderInfo.setCreateTime(LocalDateTime.now());
        senderInfo.setUpdateTime(LocalDateTime.now());

//        SenderInfo senderInfo = senderInfoService.getById(517);
        userUniqueRuleService.fire(senderInfo);
    }

    @Test
    public void testCardRule() {
        TradeInfo tradeInfo = new TradeInfo();
        tradeInfo.setId(0);
        tradeInfo.setPayeeId(0);
        tradeInfo.setPayerId(819);
        tradeInfo.setApplyNo("");
        tradeInfo.setCurrency("");
        tradeInfo.setAmount(new BigDecimal("0"));
        tradeInfo.setPayType(0);
        tradeInfo.setStatus(0);
        tradeInfo.setCreator("");
        tradeInfo.setCreateTime(LocalDateTime.now());
        tradeInfo.setUpdater("");
        tradeInfo.setUpdateTime(LocalDateTime.now());
        tradeInfo.setDestinationAmount(new BigDecimal("0"));
        tradeInfo.setDestinationCurrency("");
        tradeInfo.setCardType(0);
        tradeInfo.setCardNo("424242******4242");
        cardInfoRuleService.fire(tradeInfo);

    }

    public static void main(String[] args) {
        TradeInfo tradeInfo = new TradeInfo();
        tradeInfo.setId(0);
        tradeInfo.setPayeeId(0);
        tradeInfo.setPayerId(819);
        tradeInfo.setApplyNo("");
        tradeInfo.setCurrency("");
        tradeInfo.setAmount(new BigDecimal("0"));
        tradeInfo.setPayType(0);
        tradeInfo.setStatus(0);
        tradeInfo.setCreator("");
        tradeInfo.setCreateTime(LocalDateTime.now());
        tradeInfo.setUpdater("");
        tradeInfo.setUpdateTime(LocalDateTime.now());
        tradeInfo.setDestinationAmount(new BigDecimal("0"));
        tradeInfo.setDestinationCurrency("");
        tradeInfo.setCardType(0);
        tradeInfo.setCardNo("424242******4242");
        System.out.println(JSON.toJSONString(tradeInfo));
    }
}