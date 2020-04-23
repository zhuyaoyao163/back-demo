package com.example.backdemo.entity;

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
 * @since 2020-04-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("country")
public class Country extends Model<Country> {

    private static final long serialVersionUID = 1L;

    /**
     * 自增主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("country_iso_code")
    private String countryIsoCode;

    @TableField("country_short_code")
    private String countryShortCode;

    @TableField("country_en_name")
    private String countryEnName;

    @TableField("country_cn_name")
    private String countryCnName;

    @TableField("currency")
    private String currency;

    @TableField("area_code")
    private String areaCode;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
