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
 * 国家--kyc指标对应表
 * </p>
 *
 * @author superman
 * @since 2020-05-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_country_field")
public class TCountryField extends Model<TCountryField> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 国家
     */
    @TableField("country")
    private String country;

    /**
     * 业务类型
     */
    @TableField("business_type")
    private String businessType;

    /**
     * 业务名称(英文)
     */
    @TableField("business_name_en")
    private String businessNameEn;

    /**
     * 业务名称(中文)
     */
    @TableField("business_name_cn")
    private String businessNameCn;

    /**
     * 选择框的选项值（中文），用逗号隔开
     */
    @TableField("field_value_cn")
    private String fieldValueCn;

    /**
     * 选择框的选项值（英文），用逗号隔开
     */
    @TableField("field_value_en")
    private String fieldValueEn;

    /**
     * 字段名（英文）
     */
    @TableField("field_name_en")
    private String fieldNameEn;

    /**
     * 字段名（中文）
     */
    @TableField("field_name_cn")
    private String fieldNameCn;

    /**
     * 0-字符串， 1-数字， 2-日期（到天）3-日期（到秒） 4-单选  41-单选（选择后输入）
     */
    @TableField("field_type")
    private String fieldType;

    /**
     * 是否必填 0-选填， 1-必填
     */
    @TableField("field_required")
    private Integer fieldRequired;

    /**
     * 该指标是否是KYC必须校验指标
     */
    @TableField("kyc_required")
    private Integer kycRequired;

    /**
     * 排序序号
     */
    @TableField("order_by")
    private Integer orderBy;

    @TableField("create_time")
    private LocalDateTime createTime;

    @TableField("update_time")
    private LocalDateTime updateTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
