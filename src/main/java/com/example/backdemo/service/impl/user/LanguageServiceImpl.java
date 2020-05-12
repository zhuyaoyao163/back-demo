package com.example.backdemo.service.impl.user;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.backdemo.entity.user.Language;
import com.example.backdemo.mapper.user.LanguageMapper;
import com.example.backdemo.service.user.ILanguageService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文言国际化
10001-19999  往app返的错误编码
20001-29999 提示信息
30001-39999 标签
40001-49999  往ott pay返的错误编码 服务实现类
 * </p>
 *
 * @author superman
 * @since 2020-05-08
 */
@Service
@DS("user")
public class LanguageServiceImpl extends ServiceImpl<LanguageMapper, Language> implements ILanguageService {

}
