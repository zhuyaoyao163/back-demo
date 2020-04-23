package com.example.backdemo.service.impl;

import com.example.backdemo.entity.CardInfo;
import com.example.backdemo.mapper.CardInfoMapper;
import com.example.backdemo.service.ICardInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 风控卡信息表 服务实现类
 * </p>
 *
 * @author superman
 * @since 2020-04-23
 */
@Service
public class CardInfoServiceImpl extends ServiceImpl<CardInfoMapper, CardInfo> implements ICardInfoService {

}
