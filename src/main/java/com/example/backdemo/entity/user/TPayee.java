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
 * 记录收款人信息
 * </p>
 *
 * @author superman
 * @since 2020-05-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_payee")
public class TPayee extends Model<TPayee> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * thunes里，客户选的收款机构ID
     */
    @TableField("payer_id")
    private String payerId;

    /**
     * 用户id
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
     * 原生语言写的名字
     */
    @TableField("native_name")
    private String nativeName;

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
     * 国家代码,ISO 3166-1 alpha-3 
     */
    @TableField("country")
    private String country;

    /**
     * 省/市
     */
    @TableField("province_state")
    private String provinceState;

    @TableField("address")
    private String address;

    /**
     * 国籍,ISO 3166-1 alpha-3 
     */
    @TableField("nationality")
    private String nationality;

    /**
     * 收款方式 1-钱包  2-银行卡  3-现金
     */
    @TableField("collect_type")
    private Integer collectType;

    /**
     * YYYY-MM-DD
     */
    @TableField("birthday")
    private String birthday;

    /**
     * 0-女  1-男
     */
    @TableField("gender")
    private Integer gender;

    /**
     * 邮编
     */
    @TableField("postal_code")
    private String postalCode;

    /**
     * 固定或手机号码
     */
    @TableField("msisdn")
    private String msisdn;

    @TableField("birth_country")
    private String birthCountry;

    @TableField("source")
    private String source;

    @TableField("email")
    private String email;

    /**
     * 证件类型(1-护照 2-身份证 3-驾驶证 4-社保号  5-纳税人识别号 6-老年人证 7-出生证 8-村长证 9-永久居住在 10-外国人登记证 11-印度PAN卡号 12-选民证 13-健康保险证 14-雇主证 15-其它)
     */
    @TableField("id_type")
    private Integer idType;

    /**
     * 证件号
     */
    @TableField("id_number")
    private String idNumber;

    /**
     * 证件起效日，YYYY-MM-DD
     */
    @TableField("id_delivery_date")
    private String idDeliveryDate;

    /**
     * 证件到期日YYYY-MM-DD
     */
    @TableField("id_expiration_date")
    private String idExpirationDate;

    /**
     * 职业
     */
    @TableField("occupation")
    private String occupation;

    /**
     * t_bank_account外键
     */
    @TableField("bank_account_id")
    private Integer bankAccountId;

    @TableField("city")
    private String city;

    @TableField("payer_name")
    private String payerName;

    /**
     * 精度
     */
    @TableField("pay_precision")
    private Integer payPrecision;

    @TableField("id_pic_front")
    private String idPicFront;

    @TableField("id_pic_back")
    private String idPicBack;

    @TableField("create_time")
    private LocalDateTime createTime;

    @TableField("update_time")
    private LocalDateTime updateTime;

    /**
     * 逻辑删除，0未删除，1删除
     */
    @TableField("is_delete")
    private Integer isDelete;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
