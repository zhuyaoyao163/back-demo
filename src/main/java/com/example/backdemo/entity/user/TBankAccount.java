package com.example.backdemo.entity.user;

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
 * 银行账户信息
 * </p>
 *
 * @author superman
 * @since 2020-05-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_bank_account")
public class TBankAccount extends Model<TBankAccount> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 电话
     */
    @TableField("msisdn")
    private String msisdn;

    /**
     * 银行账号
     */
    @TableField("bank_account")
    private String bankAccount;

    /**
     * Bank account number in IBAN format
     */
    @TableField("iban")
    private String iban;

    /**
     * Bank account number in CLABE format
     */
    @TableField("clabe")
    private String clabe;

    /**
     * Bank account number in CBU format
     */
    @TableField("cbu")
    private String cbu;

    /**
     * Bank account number in CBU ALIAS format
     */
    @TableField("cbu_alias")
    private String cbuAlias;

    @TableField("swift")
    private String swift;

    /**
     * IFSC code
     */
    @TableField("ifs_code")
    private String ifsCode;

    @TableField("sort_code")
    private String sortCode;

    /**
     * ABA Routing Transfer Number
     */
    @TableField("aba_routing_number")
    private String abaRoutingNumber;

    /**
     * bsb_number
     */
    @TableField("bsb_number")
    private String bsbNumber;

    @TableField("branch_number")
    private String branchNumber;

    @TableField("account_number")
    private String accountNumber;

    @TableField("email")
    private String email;

    @TableField("entity_id")
    private String entityId;

    @TableField("precision")
    private Integer precision;

    /**
     * bank name
     */
    @TableField("bank_name")
    private String bankName;

    /**
     * bank branch name
     */
    @TableField("bank_branch_name")
    private String bankBranchName;

    @TableField("bank_code")
    private String bankCode;

    /**
     * bank address
     */
    @TableField("address")
    private String address;

    /**
     * minimum_transaction_amount
     */
    @TableField("minimum_transaction_amount")
    private String minimumTransactionAmount;

    /**
     * maximum_transaction_amount
     */
    @TableField("maximum_transaction_amount")
    private String maximumTransactionAmount;

    @TableField("create_time")
    private LocalDateTime createTime;

    @TableField("update_time")
    private LocalDateTime updateTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
