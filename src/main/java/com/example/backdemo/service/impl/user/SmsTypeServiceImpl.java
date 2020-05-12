package com.example.backdemo.service.impl.user;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.backdemo.entity.user.SmsType;
import com.example.backdemo.mapper.user.SmsTypeMapper;
import com.example.backdemo.service.user.ISmsTypeService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 短信类型 服务实现类
 * </p>
 *
 * @author superman
 * @since 2020-05-08
 */
@Service
@DS("user")
public class SmsTypeServiceImpl extends ServiceImpl<SmsTypeMapper, SmsType> implements ISmsTypeService {

}
