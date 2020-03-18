package com.example.backdemo.drool;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @description:
 * @author: superman
 * @create: 2020-02-06 16:31
 **/
@Data
@ToString
@ApiModel(value = "规则信息类")
public class RuleInfo implements Serializable {
    private static final long serialVersionUID = 7044731163532870400L;

    private String id;

    private String examineeId;

    private int salience;

    private String group;

    private String name;

    private String hitTime;

    private String responseCode;

    private String responseDesc;

    private int writeFlag;

    private String event;

    private Integer riskLevel;

    public boolean isWrite() {
        if (writeFlag == 1) {
            return true;
        }
        return false;
    }
}
