package com.example.backdemo.service.impl;

import com.example.backdemo.entity.TradeInfo;
import com.example.backdemo.mapper.TradeInfoMapper;
import com.example.backdemo.service.ITradeInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 汇款订单表 服务实现类
 * </p>
 *
 * @author superman
 * @since 2020-04-23
 */
@Service
public class TradeInfoServiceImpl extends ServiceImpl<TradeInfoMapper, TradeInfo> implements ITradeInfoService {

}
