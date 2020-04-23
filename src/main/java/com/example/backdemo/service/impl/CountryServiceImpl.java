package com.example.backdemo.service.impl;

import com.example.backdemo.entity.Country;
import com.example.backdemo.mapper.CountryMapper;
import com.example.backdemo.service.ICountryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author superman
 * @since 2020-04-23
 */
@Service
public class CountryServiceImpl extends ServiceImpl<CountryMapper, Country> implements ICountryService {

}
