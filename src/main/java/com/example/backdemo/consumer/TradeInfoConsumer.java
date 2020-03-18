package com.example.backdemo.consumer;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.backdemo.drool.TradeRiskMqRequest;
import com.example.backdemo.service.ITradeInfoService;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;

/**
 * @description:风控交易消费者
 * @author: superman
 * @create: 2020-02-11 20:17
 **/
@Component
public class TradeInfoConsumer {

    @Autowired
    private ITradeInfoService tradeInfoService;

    public void consume(TradeRiskMqRequest tradeRiskMqRequest) {

        QueryWrapper queryWrapper = new QueryWrapper();

        HashMap<Object, Object> map = Maps.newHashMap();
        map.put("apply_no", tradeRiskMqRequest.getApplyNo());
        queryWrapper.allEq(map);
        List list = tradeInfoService.list(queryWrapper);
        if (!CollectionUtils.isEmpty(list)) {
            //更新订单状态
            //重新拉去收款人信息   更新收款人
        }
    }
}
