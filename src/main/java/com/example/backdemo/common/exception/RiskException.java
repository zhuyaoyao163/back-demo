package com.example.backdemo.common.exception;


import com.example.backdemo.drool.RiskResultEnum;

/**
 * @description:
 * @author: superman
 * @create: 2020-02-11 20:09
 **/
public class RiskException extends RuntimeException{

    private String code;

    private String msg;

    private Object data;

    public RiskException() {
    }

    public RiskException(String message, Throwable cause) {
        super(message, cause);
    }

    public RiskException(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public RiskException(RiskResultEnum riskResultEnum) {
        this.code = riskResultEnum.getCode();
        this.msg = riskResultEnum.getMsgCn();
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

    @Override
    public String toString() {
        return "RiskException{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
