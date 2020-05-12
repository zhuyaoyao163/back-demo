package com.example.backdemo.service.impl.user;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.backdemo.entity.user.TPayee;
import com.example.backdemo.mapper.user.TPayeeMapper;
import com.example.backdemo.service.user.ITPayeeService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 记录收款人信息 服务实现类
 * </p>
 *
 * @author superman
 * @since 2020-05-08
 */
@Service
@DS("user")
public class TPayeeServiceImpl extends ServiceImpl<TPayeeMapper, TPayee> implements ITPayeeService {

}
