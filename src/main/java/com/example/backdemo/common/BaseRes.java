package com.example.backdemo.common;

import java.io.Serializable;

/**
 * @description: 统一返回
 * @author: superman
 * @create: 2019-12-04 16:34
 **/
public class BaseRes<T> implements Serializable {

    private String message;
    private String retCode;
    private T data;

    public BaseRes() {
        this.retCode = Constant.SUCCESS;
        this.message = Constant.SUCCESS_MSG;
    }

    public BaseRes(String retCode) {
        this.retCode = retCode;
    }

    public BaseRes(String retCode, String message) {
        this.message = message;
        this.retCode = retCode;
    }

    public BaseRes(String retCode, String message, T data) {
        this.message = message;
        this.retCode = retCode;
        this.data = data;
    }

    public BaseRes(BusinessException businessException) {
        this.retCode = businessException.getCode();
        this.message = businessException.getMsg();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        if (this == null) {
            return false;
        }
        return Constant.SUCCESS.equals(this.getRetCode());
    }

    public static BaseRes success() {
        return new BaseRes();
    }

    public static BaseRes fail() {
        BaseRes baseRes = new BaseRes();
        baseRes.setRetCode(Constant.FAIL);
        baseRes.setMessage(Constant.FAIL_MSG);
        return baseRes;
    }
    @Override
    public String toString() {
        return "BaseRes{" +
                "message='" + message + '\'' +
                ", retCode='" + retCode + '\'' +
                ", data=" + data +
                '}';
    }
}
