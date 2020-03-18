package com.example.backdemo.entity;

import java.math.BigDecimal;
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
 * 汇款订单表
 * </p>
 *
 * @author superman
 * @since 2020-02-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("trade_info")
public class TradeInfo extends Model<TradeInfo> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 收款人Id
     */
    @TableField("payee_id")
    private Integer payeeId;

    /**
     * 用户ID
     */
    @TableField("payer_id")
    private Integer payerId;

    /**
     * 申请编号
     */
    @TableField("apply_no")
    private String applyNo;

    /**
     * 汇款币种
     */
    @TableField("currency")
    private String currency;

    /**
     * 汇款金额
     */
    @TableField("amount")
    private BigDecimal amount;

    /**
     * 付款方式 
     */
    @TableField("pay_type")
    private Integer payType;

    /**
     * 汇款申请状态
     */
    @TableField("status")
    private Integer status;

    /**
     * 创建者
     */
    @TableField("creator")
    private String creator;

    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 更新人
     */
    @TableField("updater")
    private String updater;

    @TableField("update_time")
    private LocalDateTime updateTime;

    @TableField("destination_amount")
    private BigDecimal destinationAmount;

    @TableField("destination_currency")
    private String destinationCurrency;

    /**
     * 卡类型 1:借记卡 2:贷记卡
     */
    @TableField("card_type")
    private Integer cardType;

    /**
     * 卡号
     */
    @TableField("card_no")
    private String cardNo;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
