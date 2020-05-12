package com.example.backdemo.service.impl.user;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.backdemo.entity.user.TFeedback;
import com.example.backdemo.mapper.user.TFeedbackMapper;
import com.example.backdemo.service.user.ITFeedbackService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 记录客户反馈意见，qa等 服务实现类
 * </p>
 *
 * @author superman
 * @since 2020-05-08
 */
@Service
@DS("user")
public class TFeedbackServiceImpl extends ServiceImpl<TFeedbackMapper, TFeedback> implements ITFeedbackService {

}
