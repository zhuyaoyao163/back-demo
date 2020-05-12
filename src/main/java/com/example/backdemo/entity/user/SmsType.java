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
 * 短信类型
 * </p>
 *
 * @author superman
 * @since 2020-05-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sms_type")
public class SmsType extends Model<SmsType> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 每个imei号每日允许的最大次数
     */
    @TableField("imei_max")
    private Integer imeiMax;

    /**
     * 每个IP每日允许的最大次数
     */
    @TableField("ip_max")
    private Integer ipMax;

    /**
     * 备注
     */
    @TableField("note")
    private String note;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
