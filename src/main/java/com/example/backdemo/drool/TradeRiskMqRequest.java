package com.example.backdemo.drool;

import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @author: superman
 * @create: 2020-02-11 20:19
 **/
@Data
public class TradeRiskMqRequest implements Serializable {

    private static final long serialVersionUID = -2088798765602747823L;

    private String applyNo;

    private Integer status;

    private String orderDesc;
}
