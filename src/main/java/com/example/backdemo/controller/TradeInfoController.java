package com.example.backdemo.controller;


import com.example.backdemo.entity.TradeInfo;
import com.example.backdemo.service.ITradeInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 汇款订单表 前端控制器
 * </p>
 *
 * @author superman
 * @since 2020-04-23
 */
@RestController
@RequestMapping("/risk/trade-info")
@Slf4j
public class TradeInfoController {

    @Autowired
    private ITradeInfoService tradeInfoService;

    @PostMapping("/list")
    public Object list(){
        log.info("========================");
        List<TradeInfo> list = tradeInfoService.list();
        log.info(list.size() + "");
        return list;
    }
}
