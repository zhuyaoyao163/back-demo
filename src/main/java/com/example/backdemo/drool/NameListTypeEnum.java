package com.example.backdemo.drool;

/**
 * @description:
 * @author: superman
 * @create: 2020-02-11 15:45
 **/
public enum NameListTypeEnum {
    SENDER_BLACK_LIST("SENDER_BLACK_LIST","汇款人黑名单"),
    PAYEE_BLACK_LIST("PAYEE_BLACK_LIST","收款人黑名单"),
    ;

    private String code;

    private String value;

    NameListTypeEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
