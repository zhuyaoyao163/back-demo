package com.example.backdemo.mapper.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.backdemo.entity.user.Language;

/**
 * <p>
 * 文言国际化
10001-19999  往app返的错误编码
20001-29999 提示信息
30001-39999 标签
40001-49999  往ott pay返的错误编码 Mapper 接口
 * </p>
 *
 * @author superman
 * @since 2020-05-08
 */
public interface LanguageMapper extends BaseMapper<Language> {

}
