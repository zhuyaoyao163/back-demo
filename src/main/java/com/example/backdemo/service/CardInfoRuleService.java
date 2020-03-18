package com.example.backdemo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.backdemo.common.exception.HitRuleException;
import com.example.backdemo.drool.RuleEventEnum;
import com.example.backdemo.drool.RuleInfo;
import com.example.backdemo.drool.RuleTypeMappingEnum;
import com.example.backdemo.entity.CardInfo;
import com.example.backdemo.entity.RiskRecond;
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
 * @create: 2020-02-14 15:53
 **/
@Service
@Slf4j
public class CardInfoRuleService {

    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private ICardInfoService cardInfoService;

    @Autowired
    private ITradeInfoService tradeInfoService;

    @Autowired
    private IRiskRecondService riskRecondService;

    public RuleInfo fire(TradeInfo tradeInfo) {
        RuleInfo ruleInfo = new RuleInfo();
        KieSession kieSession = kieContainer.newKieSession();

        try {
            FactHandle ruleInfoHandle = kieSession.insert(ruleInfo);
            FactHandle tradeInfoHandle = kieSession.insert(tradeInfo);
            FactHandle cardInfoHandle = null;
            List<TradeInfo> failTradeDayList = getFailTradeDayList(tradeInfo.getCardNo());
            if (!CollectionUtils.isEmpty(failTradeDayList)) {
                kieSession.setGlobal("cardFailDayInfoList", failTradeDayList);
            }
            List<RiskRecond> blackHistoryList = getBlackHistoryList(tradeInfo.getCardNo());
            if (!CollectionUtils.isEmpty(blackHistoryList)) {
                kieSession.setGlobal("cardBlackHistoryList", blackHistoryList);
            }

            Map<String, Object> map = Maps.newHashMap();
            map.put("card_no", tradeInfo.getCardNo());
            QueryWrapper<CardInfo> queryWrapper = new QueryWrapper();
            queryWrapper.allEq(map);
            List<CardInfo> cardInfoList = cardInfoService.list(queryWrapper);
            for (CardInfo cardInfo : cardInfoList) {
                if (cardInfoHandle == null) {
                    cardInfoHandle = kieSession.insert(cardInfo);
                } else {
                    kieSession.update(cardInfoHandle, cardInfo);
                }
                AgendaFilter agendaFilter = new RuleNameStartsWithAgendaFilter(RuleTypeMappingEnum.CARD_INFO.getValue());
                int allRules = kieSession.fireAllRules(agendaFilter);
                log.info("执行了{}条规则", allRules);
                if (null != ruleInfo.getId()) {
                    break;
                }
                if (null != cardInfoHandle) {
                    kieSession.delete(cardInfoHandle);
                }
            }
            kieSession.delete(ruleInfoHandle);
            kieSession.delete(tradeInfoHandle);
            kieSession.dispose();
        } catch (Exception e) {
            // TODO: 2020-02-14 抛出自定义异常
            e.printStackTrace();
        } finally {
            if (null != kieSession) {
                kieSession.dispose();
            }
        }
        //白名单处理
        if (ruleInfo.isWrite()) {
            log.info(ruleInfo.getName());
            ruleInfo = new RuleInfo();
        }
        if (null != ruleInfo.getId()) {
            throw new HitRuleException(ruleInfo);
        }
        return ruleInfo;
    }

    /**
     * 查找指定卡号当天失败的订单
     * @param cardNo
     * @return
     */
    public List<TradeInfo> getFailTradeDayList(String cardNo){
        Map<String, Object> map = Maps.newHashMap();
        map.put("card_no", cardNo);
        QueryWrapper<TradeInfo> queryWrapper = new QueryWrapper();
        queryWrapper.allEq(map);
        return tradeInfoService.list(queryWrapper);
    }

    public List<RiskRecond> getBlackHistoryList(String cardNo) {
        Map<String, Object> map = Maps.newHashMap();
        map.put("card_no", cardNo);
        QueryWrapper<RiskRecond> queryWrapper = new QueryWrapper();
        queryWrapper.allEq(map);
        queryWrapper.ne("event", RuleEventEnum.CARD_WHITE_NAME_LIST.getCode());
        return riskRecondService.list(queryWrapper);
    }
}
