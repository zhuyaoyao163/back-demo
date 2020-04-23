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
 * 风控收款人信息
 * </p>
 *
 * @author superman
 * @since 2020-04-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("payee_info")
public class PayeeInfo extends Model<PayeeInfo> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户ID
     */
    @TableField("payee_id")
    private Integer payeeId;

    /**
     * 汇款人id
     */
    @TableField("customer_id")
    private Integer customerId;

    @TableField("first_name")
    private String firstName;

    @TableField("middle_name")
    private String middleName;

    @TableField("last_name")
    private String lastName;

    /**
     * 付款币种
     */
    @TableField("frm_currency")
    private String frmCurrency;

    /**
     * 收款币种
     */
    @TableField("to_currency")
    private String toCurrency;

    /**
     * 收款方式 1-钱包  2-银行卡  3-现金
     */
    @TableField("collect_type")
    private Integer collectType;

    /**
     * t_bank_account外键
     */
    @TableField("bank_account_id")
    private Integer bankAccountId;

    /**
     * 是否白名单  1:是  0:否
     */
    @TableField("white_flag")
    private Integer whiteFlag;

    /**
     * 是否黑名单  1:是   0:否
     */
    @TableField("black_flag")
    private Integer blackFlag;

    /**
     * 拉入黑名单原因
     */
    @TableField("black_desc")
    private String blackDesc;

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


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
