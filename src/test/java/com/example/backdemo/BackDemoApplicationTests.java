package com.example.backdemo;
import com.example.backdemo.entity.CardInfo;
import com.example.backdemo.service.ICardInfoService;
import com.google.common.collect.Lists;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.backdemo.drool.RuleEventEnum;
import com.example.backdemo.entity.RiskRecond;
import com.example.backdemo.entity.TradeInfo;
import com.example.backdemo.service.IRiskRecondService;
import com.example.backdemo.service.ITradeInfoService;
import com.example.backdemo.service.UserUniqueRuleService;
import com.google.common.collect.Maps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.WeakHashMap;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.example.backdemo.mapper")
public class BackDemoApplicationTests {

    @Autowired
    private ITradeInfoService tradeInfoService;

    @Autowired
    private IRiskRecondService riskRecondService;

    @Autowired
    private ICardInfoService cardInfoService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testSelect() {
        Page<TradeInfo> tradeInfoPage = new Page<>();

        tradeInfoPage.setCurrent(3);
        QueryWrapper<TradeInfo> queryWrapper = new QueryWrapper<>();
        System.out.println(JSON.toJSONString(tradeInfoPage));
        Page<TradeInfo> page = tradeInfoService.page(tradeInfoPage, queryWrapper);
        System.out.println(JSON.toJSONString(page));
    }

    @Test
    public void testSave() {
        TradeInfo tradeInfo = new TradeInfo();
        tradeInfo.setPayeeId(0);
        tradeInfo.setPayerId(0);
        tradeInfo.setApplyNo("R43534534");
        tradeInfo.setCurrency("CNY");
        tradeInfo.setAmount(new BigDecimal("0"));
        tradeInfo.setPayType(0);
        tradeInfo.setStatus(0);
        tradeInfo.setCreateTime(LocalDateTime.now());
        tradeInfo.setUpdateTime(LocalDateTime.now());
        tradeInfo.setDestinationAmount(new BigDecimal("0"));
        tradeInfo.setDestinationCurrency("");
        tradeInfo.setCardType(0);
        tradeInfo.setCardNo("");
//        boolean insert = tradeInfo.insert();
        boolean save = tradeInfoService.save(tradeInfo);
        System.out.println(save);
    }

    @Test
    public void testDate() {
        QueryWrapper<RiskRecond> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", 3232);
        queryWrapper.eq("event", RuleEventEnum.SINGLE_DAY_LIMIT_NUMS.getCode());
        queryWrapper.gt("create_time", LocalDate.now().minusDays(4));
        List<RiskRecond> list = riskRecondService.list(queryWrapper);
        System.out.println(JSON.toJSONString(list));
    }


    @Test
    public void testSaveOrUpdate() {
        CardInfo cardInfo = new CardInfo();
        cardInfo.setCardNo("424242******4242");
        cardInfo.setUpdateTime(LocalDateTime.now());
        QueryWrapper<CardInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("card_no", "424242******4242");
        cardInfoService.saveOrUpdate(cardInfo, queryWrapper);
    }
    public static void main(String[] args) {
        WeakHashMap map = new WeakHashMap();
    }

}
