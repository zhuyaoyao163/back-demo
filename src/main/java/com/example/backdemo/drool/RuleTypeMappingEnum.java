package com.example.backdemo.drool;

/**
 * @description:
 * @author: superman
 * @create: 2020-02-10 17:42
 **/
public enum RuleTypeMappingEnum {

    TRADE_STATISTICS("TRADE_STATISTICS","TRADE_STATISTICS"),
    TRADE_SINGLE("TRADE_SINGLE","TRADE_SINGLE"),
    BLACK_NAME_LIST("BLACK_NAME_LIST","BLACK_NAME_LIST"),
    CARD_INFO("CARD_INFO","CARD_INFO"),
    WRITE_SENDER("WRITE_SENDER","WRITE_SENDER"),
    USER_UNIQUE("USER_UNIQUE","USER_UNIQUE"),
    ;

    private String code;

    private String value;

    RuleTypeMappingEnum(String code, String value) {
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
