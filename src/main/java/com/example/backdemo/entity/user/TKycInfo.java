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
 * 
 * </p>
 *
 * @author superman
 * @since 2020-05-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_kyc_info")
public class TKycInfo extends Model<TKycInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户ID
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 国家代码
     */
    @TableField("country")
    private String country;

    /**
     * 国家校验状态
     */
    @TableField("country_status")
    private String countryStatus;

    /**
     * 发送到shufti pro的唯一编号
     */
    @TableField("reference")
    private String reference;

    /**
     * 名
     */
    @TableField("first_name")
    private String firstName;

    /**
     * 姓
     */
    @TableField("last_name")
    private String lastName;

    @TableField("lastname2")
    private String lastname2;

    @TableField("nativename")
    private String nativename;

    /**
     * 国籍的国家代码
     */
    @TableField("nationality_country_iso_code")
    private String nationalityCountryIsoCode;

    /**
     * send identify code
     */
    @TableField("code")
    private String code;

    /**
     * 出生国家代码
     */
    @TableField("country_of_birth_iso_code")
    private String countryOfBirthIsoCode;

    /**
     * 邮编
     */
    @TableField("postal_code")
    private String postalCode;

    /**
     * 城市
     */
    @TableField("city")
    private String city;

    /**
     * 国家名称
     */
    @TableField("Country_name")
    private String countryName;

    /**
     * 建筑编号或名称
     */
    @TableField("Building_No_or_name")
    private String buildingNoOrName;

    /**
     * 街道
     */
    @TableField("Street")
    private String Street;

    /**
     * 地址国家
     */
    @TableField("country_iso_code")
    private String countryIsoCode;

    /**
     * 联系电话
     */
    @TableField("msisdn")
    private String msisdn;

    /**
     * 职业
     */
    @TableField("occupation")
    private String occupation;

    /**
     * 银行
     */
    @TableField("bank")
    private String bank;

    /**
     * 银行账号
     */
    @TableField("bank_account")
    private String bankAccount;

    /**
     * 信用卡号(app不显示)
     */
    @TableField("card")
    private String card;

    /**
     * 省市
     */
    @TableField("province_state")
    private String provinceState;

    /**
     * 受益人关系(app不显示)
     */
    @TableField("beneficiary_relationship")
    private String beneficiaryRelationship;

    /**
     * 资金来源
     */
    @TableField("source_of_funds")
    private String sourceOfFunds;

    @TableField("name_status")
    private String nameStatus;

    /**
     * 出生日期
     */
    @TableField("dob")
    private String dob;

    @TableField("dob_status")
    private String dobStatus;

    /**
     * 具体地址
     */
    @TableField("full_address")
    private String fullAddress;

    @TableField("full_address_status")
    private String fullAddressStatus;

    /**
     * 证件类型 1-身份证 2-驾照 3-护照
     */
    @TableField("document_type")
    private String documentType;

    @TableField("document_type_status")
    private String documentTypeStatus;

    /**
     * 证件有效起始日
     */
    @TableField("issue_date")
    private String issueDate;

    @TableField("issue_date_status")
    private String issueDateStatus;

    /**
     * 证件有效结束日
     */
    @TableField("expiry_date")
    private String expiryDate;

    @TableField("expiry_date_status")
    private String expiryDateStatus;

    /**
     * 证件号码
     */
    @TableField("document_number")
    private String documentNumber;

    @TableField("document_number_status")
    private String documentNumberStatus;

    /**
     * 证件照片地址
     */
    @TableField("document_url")
    private String documentUrl;

    /**
     * 证件照反面URL地址
     */
    @TableField("document_addition_url")
    private String documentAdditionUrl;

    /**
     * 地址证件类型
     */
    @TableField("address_type")
    private String addressType;

    @TableField("address_type_status")
    private String addressTypeStatus;

    /**
     * 地址文件url
     */
    @TableField("address_url")
    private String addressUrl;

    /**
     * 人脸图片URL
     */
    @TableField("face_url")
    private String faceUrl;

    /**
     * StatusEnums
     */
    @TableField("face_status")
    private String faceStatus;

    @TableField("background_status")
    private String backgroundStatus;

    /**
     * 创建日期
     */
    @TableField("create_time")
    private Long createTime;

    /**
     * 修改日期
     */
    @TableField("update_time")
    private Long updateTime;

    @TableField("user_no")
    private String userNo;

    @TableField("check_type")
    private String checkType;

    @TableField("status")
    private String status;

    @TableField("document_url_status")
    private String documentUrlStatus;

    @TableField("document_addition_url_status")
    private String documentAdditionUrlStatus;

    @TableField("address_url_status")
    private String addressUrlStatus;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
