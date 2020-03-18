package com.example.backdemo.drool;

/**
 * @description: member  code msg 说明
 * @author: superman
 * @create: 2019-11-30 18:57
 **/
public enum RiskResultEnum {
    PARAM_IS_ERROR("10310001","参数异常","Unexpected error, please contact our support team"),
    SYSTEM_ERROR("10310002","系统异常","system error"),
    ERROR_CODE("code","中文提示","英文提示");


    private String code;
    private String msgCn;
    private String msgEn;

    RiskResultEnum(String code, String msgCn, String msgEn) {
        this.code = code;
        this.msgCn = msgCn;
        this.msgEn = msgEn;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsgCn() {
        return msgCn;
    }

    public void setMsgCn(String msgCn) {
        this.msgCn = msgCn;
    }

    public String getMsgEn() {
        return msgEn;
    }

    public void setMsgEn(String msgEn) {
        this.msgEn = msgEn;
    }
}
