package com.example.backdemo.common;

public class BusinessException extends RuntimeException{

    private String code;

    private String msg;

    private Object data;

    public BusinessException(String code, String msg, Object... objects){
        this.code = code;
        this.msg = msg;
        if(null != objects && objects.length > 0){
            this.data = objects[0];
        }
    }

    public BusinessException(String code, Object... args) {
        super();
        this.code = code;
        this.data = args;
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
}
