package com.example.backdemo.service.impl.user;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.backdemo.entity.user.TKycStatus;
import com.example.backdemo.mapper.user.TKycStatusMapper;
import com.example.backdemo.service.user.ITKycStatusService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 业务模块KYC审核状态表 服务实现类
 * </p>
 *
 * @author superman
 * @since 2020-05-08
 */
@Service
@DS("user")
public class TKycStatusServiceImpl extends ServiceImpl<TKycStatusMapper, TKycStatus> implements ITKycStatusService {

}
