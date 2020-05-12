package com.example.backdemo.service.impl.user;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.backdemo.entity.user.TBankAccount;
import com.example.backdemo.mapper.user.TBankAccountMapper;
import com.example.backdemo.service.user.ITBankAccountService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 银行账户信息 服务实现类
 * </p>
 *
 * @author superman
 * @since 2020-05-08
 */
@Service
@DS("user")
public class TBankAccountServiceImpl extends ServiceImpl<TBankAccountMapper, TBankAccount> implements ITBankAccountService {

}
