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
 * 客户申诉表
 * </p>
 *
 * @author superman
 * @since 2020-05-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("appeal")
public class Appeal extends Model<Appeal> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("imei")
    private String imei;

    /**
     * 投诉类型，app从setting中获取
     */
    @TableField("type")
    private String type;

    /**
     * 注册手机或邮箱
     */
    @TableField("regist_account")
    private String registAccount;

    /**
     * 联系人
     */
    @TableField("link_man")
    private String linkMan;

    /**
     * 联系电话
     */
    @TableField("link_tel")
    private String linkTel;

    /**
     * 联系人邮箱
     */
    @TableField("link_mail")
    private String linkMail;

    /**
     * boss_login的id
     */
    @TableField("do_usr_id")
    private Integer doUsrId;

    /**
     * 处理人名
     */
    @TableField("do_usr_name")
    private String doUsrName;

    /**
     * 处理结果
     */
    @TableField("result")
    private String result;

    /**
     * 处理状态，Enums.AppealStatus
     */
    @TableField("status")
    private Integer status;

    @TableField("create_time")
    private Long createTime;

    @TableField("modify_time")
    private Long modifyTime;

    @TableField("message")
    private String message;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
