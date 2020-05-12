package com.example.backdemo.service.impl.user;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.backdemo.entity.user.Appeal;
import com.example.backdemo.mapper.user.AppealMapper;
import com.example.backdemo.service.user.IAppealService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 客户申诉表 服务实现类
 * </p>
 *
 * @author superman
 * @since 2020-05-08
 */
@Service
@DS("user")
public class AppealServiceImpl extends ServiceImpl<AppealMapper, Appeal> implements IAppealService {

}
