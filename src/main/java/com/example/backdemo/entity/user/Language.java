package com.example.backdemo.entity.user;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 文言国际化
10001-19999  往app返的错误编码
20001-29999 提示信息
30001-39999 标签
40001-49999  往ott pay返的错误编码
 * </p>
 *
 * @author superman
 * @since 2020-05-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("language")
public class Language extends Model<Language> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 错误编码
     */
    @TableField("msgCode")
    private Integer msgCode;

    /**
     * 错误信息(中文)
     */
    @TableField("msgCn")
    private String msgCn;

    /**
     * 错误信息(英文)
     */
    @TableField("msgEn")
    private String msgEn;

    /**
     * 说明
     */
    @TableField("remark")
    private String remark;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
