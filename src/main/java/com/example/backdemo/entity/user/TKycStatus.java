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
 * 业务模块KYC审核状态表
 * </p>
 *
 * @author superman
 * @since 2020-05-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_kyc_status")
public class TKycStatus extends Model<TKycStatus> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 发送到shufti pro的唯一编号
     */
    @TableField("reference")
    private String reference;

    /**
     * 用户ID
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 业务模块
     */
    @TableField("business_type")
    private String businessType;

    /**
     * 审核状态 00-未通过 01-已通过 02-审核中
     */
    @TableField("status")
    private String status;

    /**
     * 未通过原因
     */
    @TableField("decline_reason")
    private String declineReason;

    @TableField("create_time")
    private Long createTime;

    @TableField("update_time")
    private Long updateTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
