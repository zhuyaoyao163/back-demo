package com.example.backdemo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.backdemo.common.BaseRes;
import com.example.backdemo.common.Constant;
import com.example.backdemo.common.exception.HitRuleException;
import com.example.backdemo.drool.NameListTypeEnum;
import com.example.backdemo.drool.RuleInfo;
import com.example.backdemo.drool.RuleTypeMappingEnum;
import com.example.backdemo.entity.CardInfo;
import com.example.backdemo.entity.RiskRule;
import com.example.backdemo.entity.SenderInfo;
import com.example.backdemo.entity.TradeInfo;
import com.example.backdemo.service.*;
import com.google.common.collect.Maps;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @description:
 * @author: superman
 * @create: 2020-02-11 17:48
 **/

@RestController
@RequestMapping("/risk")
@Api(tags = "风控相关接口")
@Slf4j
public class RuleProcessController {
    @Autowired
    private ISenderInfoService senderInfoService;

    @Autowired
    private ITradeInfoService tradeInfoService;

    @Autowired
    private TradeInfoRuleService tradeInfoRuleService;

    @Autowired
    private IRiskRuleService riskRuleService;

    @Autowired
    private NameListRuleService nameListRuleService;

    @Autowired
    private CardInfoRuleService cardInfoRuleService;
    /**
     * 添加黑名单（汇款人）
     * @param senderInfo
     * @return
     */
    @PostMapping("/addSenderBlackNameList")
    @ApiOperation("添加黑名单")
    public BaseRes addSenderBlackNameList(@RequestBody SenderInfo senderInfo) {
        BaseRes baseRes = new BaseRes();
        boolean res = senderInfoService.save(senderInfo);
        payeeIsBlack(senderInfo.getUserId());
        if (!res) {
            baseRes.setRetCode(Constant.FAIL);
        }
        return baseRes;
    }

    @PostMapping("/securityCheck")
    @ApiOperation("风控检查")
    public BaseRes<RuleInfo> securityCheck(@RequestBody TradeInfo tradeInfo) {
        BaseRes baseRes = new BaseRes();
        RuleInfo ruleInfo = new RuleInfo();
        try {
            List<RiskRule> riskRules = riskRuleService.list();

            //汇款人黑名单
            nameListRuleService.fire(tradeInfo, NameListTypeEnum.SENDER_BLACK_LIST);

            //收款人黑名单
            nameListRuleService.fire(tradeInfo, NameListTypeEnum.PAYEE_BLACK_LIST);

            //单笔交易规则
            tradeInfoRuleService.fire(tradeInfo, riskRules, RuleTypeMappingEnum.TRADE_SINGLE);

            //统计交易规则
            tradeInfoRuleService.fire(tradeInfo, riskRules, RuleTypeMappingEnum.TRADE_STATISTICS);

            cardInfoRuleService.fire(tradeInfo);
        } catch (HitRuleException e) {
            //命中规则
            log.info("命中规则，rule:{}",ruleInfo.toString());
            baseRes.setRetCode(Constant.FAIL);
            baseRes.setData(e.getRuleInfo());
        } catch (Exception e) {
            log.error("调用风控系统异常", e);
            log.info("发生异常侯先不影响正常业务，当成功返回");
        }
        return baseRes;
    }

    @PostMapping("/addCardBlackNameList")
    @ApiOperation("银行卡添加黑名单")
    public BaseRes addCardBlackNameList(@RequestBody CardInfo cardInfo) {

        return new BaseRes();
    }


    /**
     * 线程池执行  后续优化
     * 自动统计加入黑名单中的对应收款人，将超过2个的黑名单人员付给同一收款人的情况记录下来，并将收款人自动加入黑名单。
     * @param userId
     */
    private void payeeIsBlack(Integer userId) {
        QueryWrapper queryWrapper = new QueryWrapper();

        HashMap<Object, Object> map = Maps.newHashMap();
        map.put("payer_id", userId);
        queryWrapper.allEq(map);
//     flag   true 加入黑名单   false 不用加入黑名单
    }
}
