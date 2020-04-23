package com.example.backdemo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 风控卡信息表
 * </p>
 *
 * @author superman
 * @since 2020-04-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("card_info")
public class CardInfo extends Model<CardInfo> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 卡号
     */
    @TableField("card_no")
    private String cardNo;

    /**
     * 卡类型 1:借记卡  2:信用卡
     */
    @TableField("card_type")
    private Integer cardType;

    /**
     * 用户ID
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 使用时间
     */
    @TableField("use_time")
    private LocalDateTime useTime;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private LocalDateTime updateTime;

    /**
     * 1:拉入黑名单 0正常
     */
    @TableField("black_flag")
    private Integer blackFlag;

    /**
     * 1:白名单 
     */
    @TableField("white_flag")
    private Integer whiteFlag;

    /**
     * 国家代码
     */
    @TableField("country_code")
    private String countryCode;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
