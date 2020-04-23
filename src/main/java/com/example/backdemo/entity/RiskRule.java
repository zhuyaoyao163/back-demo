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
 * 风控规则表
 * </p>
 *
 * @author superman
 * @since 2020-04-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("risk_rule")
public class RiskRule extends Model<RiskRule> {

    private static final long serialVersionUID = 1L;

    /**
     * 自增长ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 任务ID
     */
    @TableField("task_id")
    private Long taskId;

    /**
     * 事件
     */
    @TableField("event")
    private String event;

    /**
     * 规则优先级
     */
    @TableField("priority")
    private Integer priority;

    /**
     * 创建者
     */
    @TableField("create_by")
    private String createBy;

    /**
     * 修改者
     */
    @TableField("update_by")
    private String updateBy;

    /**
     * 只做标识，不真正删除数据
     */
    @TableField("is_delete")
    private String isDelete;

    /**
     * 时间段
     */
    @TableField("time_segment")
    private Integer timeSegment;

    /**
     * 时间单位
     */
    @TableField("time_unit")
    private String timeUnit;

    /**
     * 交易开始时间
     */
    @TableField("trade_start_time")
    private LocalDateTime tradeStartTime;

    /**
     * 交易结束时间
     */
    @TableField("trade_end_time")
    private LocalDateTime tradeEndTime;

    /**
     * 交易笔数限制
     */
    @TableField("trade_limit_nums")
    private Integer tradeLimitNums;

    /**
     * 交易金额币种
     */
    @TableField("trade_limit_money_currency")
    private String tradeLimitMoneyCurrency;

    /**
     * 交易金额限制
     */
    @TableField("trade_limit_money")
    private Integer tradeLimitMoney;

    /**
     * 注册国家iso编码
     */
    @TableField("register_country_iso_code")
    private String registerCountryIsoCode;

    /**
     * kyc国家iso编码
     */
    @TableField("kyc_country_iso_code")
    private String kycCountryIsoCode;

    /**
     * 规则开始时间
     */
    @TableField("rule_start_time")
    private LocalDateTime ruleStartTime;

    /**
     * 规则结束时间
     */
    @TableField("rule_end_time")
    private LocalDateTime ruleEndTime;

    /**
     * 规则优先级
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
