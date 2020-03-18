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
 * 风控记录表
 * </p>
 *
 * @author superman
 * @since 2020-02-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("risk_recond")
public class RiskRecond extends Model<RiskRecond> {

    private static final long serialVersionUID = 1L;

    /**
     * 自增长ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 规则ID
     */
    @TableField("rule_id")
    private Integer ruleId;

    /**
     * 事件
     */
    @TableField("event")
    private String event;

    /**
     * 用户Id
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 订单号
     */
    @TableField("apply_no")
    private String applyNo;

    /**
     * 卡号
     */
    @TableField("card_no")
    private String cardNo;

    /**
     * 只做标识，不真正删除数据
     */
    @TableField("is_delete")
    private String isDelete;

    /**
     * 规则级别
     */
    @TableField("risk_level")
    private Integer riskLevel;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @TableField("update_time")
    private LocalDateTime updateTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
