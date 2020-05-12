package com.example.backdemo.service.impl.user;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.backdemo.entity.user.TKycInfo;
import com.example.backdemo.mapper.user.TKycInfoMapper;
import com.example.backdemo.service.user.ITKycInfoService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author superman
 * @since 2020-05-08
 */
@Service
@DS("user")
public class TKycInfoServiceImpl extends ServiceImpl<TKycInfoMapper, TKycInfo> implements ITKycInfoService {

}
