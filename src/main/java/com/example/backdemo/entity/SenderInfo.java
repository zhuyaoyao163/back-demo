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
 * 风控汇款人信息
 * </p>
 *
 * @author superman
 * @since 2020-02-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sender_info")
public class SenderInfo extends Model<SenderInfo> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户ID
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 出生日期
     */
    @TableField("dob")
    private String dob;

    /**
     * 具体地址
     */
    @TableField("full_address")
    private String fullAddress;

    /**
     * 证件类型 1-身份证 2-驾照 3-护照
     */
    @TableField("document_type")
    private String documentType;

    /**
     * 证件有效起始日
     */
    @TableField("issue_date")
    private String issueDate;

    /**
     * 证件有效结束日
     */
    @TableField("expiry_date")
    private String expiryDate;

    /**
     * 证件号码
     */
    @TableField("document_number")
    private String documentNumber;

    /**
     * 手机号
     */
    @TableField("mobile")
    private String mobile;

    /**
     * 注册国家编码
     */
    @TableField("register_country_iso_code")
    private String registerCountryIsoCode;

    /**
     * kyc国家编码
     */
    @TableField("kyc_country_iso_code")
    private String kycCountryIsoCode;

    /**
     * 邮箱地址
     */
    @TableField("email")
    private String email;

    @TableField("first_name")
    private String firstName;

    @TableField("last_name")
    private String lastName;

    /**
     * 是否白名单  1:是 0:否
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
