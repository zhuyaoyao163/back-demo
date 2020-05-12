package com.example.backdemo.service.user;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.backdemo.entity.user.Language;

/**
 * <p>
 * 文言国际化
10001-19999  往app返的错误编码
20001-29999 提示信息
30001-39999 标签
40001-49999  往ott pay返的错误编码 服务类
 * </p>
 *
 * @author superman
 * @since 2020-05-08
 */
public interface ILanguageService extends IService<Language> {

}
