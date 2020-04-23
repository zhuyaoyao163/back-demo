package com.example.backdemo.service.impl;

import com.example.backdemo.entity.PayeeInfo;
import com.example.backdemo.mapper.PayeeInfoMapper;
import com.example.backdemo.service.IPayeeInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 风控收款人信息 服务实现类
 * </p>
 *
 * @author superman
 * @since 2020-04-23
 */
@Service
public class PayeeInfoServiceImpl extends ServiceImpl<PayeeInfoMapper, PayeeInfo> implements IPayeeInfoService {

}
