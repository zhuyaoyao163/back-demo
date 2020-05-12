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
 * 记录客户反馈意见，qa等
 * </p>
 *
 * @author superman
 * @since 2020-05-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_feedback")
public class TFeedback extends Model<TFeedback> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 1-反馈意见  2-QA  3-汇款求帮助
     */
    @TableField("type")
    private Integer type;

    /**
     * 提问人
     */
    @TableField("name")
    private String name;

    /**
     * 提问人邮箱
     */
    @TableField("email")
    private String email;

    /**
     * 提问人手机
     */
    @TableField("mobile")
    private String mobile;

    /**
     * 提问人电话
     */
    @TableField("phone")
    private String phone;

    /**
     * 提问人内容
     */
    @TableField("content")
    private String content;

    /**
     * 平台处理结果
     */
    @TableField("feedback")
    private String feedback;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
