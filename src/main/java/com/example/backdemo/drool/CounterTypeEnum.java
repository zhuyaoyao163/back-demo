package com.example.backdemo.drool;

/**
 * @description:
 * @author: superman
 * @create: 2020-02-10 11:06
 **/
public enum  CounterTypeEnum {

    MONEY("MONEY"),
    NUMS("NUMS");

    CounterTypeEnum(String type) {
        this.type = type;
    }

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
