package com.example.backdemo.common.exception;


import com.example.backdemo.drool.RuleInfo;

public class HitRuleException extends RuntimeException{

    private String code;

    private String msg;

    private Object data;

    private RuleInfo ruleInfo;

    public HitRuleException() {
    }

    public HitRuleException(RuleInfo ruleInfo) {
        this.ruleInfo = ruleInfo;
    }

    public HitRuleException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public HitRuleException(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }



    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public RuleInfo getRuleInfo() {
        return ruleInfo;
    }

    public void setRuleInfo(RuleInfo ruleInfo) {
        this.ruleInfo = ruleInfo;
    }

    @Override
    public String toString() {
        return "HitRuleException{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", ruleInfo=" + ruleInfo +
                '}';
    }
}
