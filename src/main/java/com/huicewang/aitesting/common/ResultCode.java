package com.huicewang.aitesting.common;

public enum  ResultCode implements IErrorCode {
    SUCCESS(200,"操作成功"),
    FAILED(500,"操作失败"),
    UNAUTHORIZEN(401,"没有权限"),
    VALIDATE_FAILED(404,"参数验证失败"),
    FORBIDDEN(403,"操作禁止");

    private long code;
    private String Message;
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
