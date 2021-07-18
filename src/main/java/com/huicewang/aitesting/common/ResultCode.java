package com.huicewang.aitesting.common;

public enum  ResultCode implements IErrorCode {
    SUCCESS(200,"操作成功"),
    FAILED(500,"操作失败"),
    UNAUTHORIZEN(401,"没有权限"),
    FORBIDDEN(403,"操作禁止");

    long code;
    String Message;
    private  ResultCode(long code,String message){
        this.code=code;
        this.Message=message;
    }
    @Override
    public long getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.Message;
    }
}
