package com.example.backdemo.service.impl.user;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.backdemo.entity.user.TCountryField;
import com.example.backdemo.mapper.user.TCountryFieldMapper;
import com.example.backdemo.service.user.ITCountryFieldService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 国家--kyc指标对应表 服务实现类
 * </p>
 *
 * @author superman
 * @since 2020-05-08
 */
@Service
@DS("user")
public class TCountryFieldServiceImpl extends ServiceImpl<TCountryFieldMapper, TCountryField> implements ITCountryFieldService {

}
