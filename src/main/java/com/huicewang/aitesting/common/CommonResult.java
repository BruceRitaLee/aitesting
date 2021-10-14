package com.huicewang.aitesting.common;

import lombok.Getter;
/**
 * 我现在感觉很牛逼
 * */

@Getter
public class CommonResult<T> {
    private long code;
    private String message;
    private T data;

    public CommonResult(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
    public CommonResult(long code, String message) {
        this.code = code;
        this.message = message;
    }

    public CommonResult(String defaultMessage) {
        this.message=defaultMessage;
    }


    public static<D> CommonResult success(D data){
        return  new CommonResult<>(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMessage(),data);

    }
    public static<D> CommonResult failed(D data){
        return  new CommonResult<>(ResultCode.FAILED.getCode(),ResultCode.FAILED.getMessage(),data);

    }
    public static<D> CommonResult unauthorizen(D data){
        return  new CommonResult<>(ResultCode.UNAUTHORIZEN.getCode(),ResultCode.UNAUTHORIZEN.getMessage(),data);

    }
    public static<D> CommonResult forbidden(D data){
        return  new CommonResult<>(ResultCode.FORBIDDEN.getCode(),ResultCode.FORBIDDEN.getMessage(),data);

    }
    public static<D> CommonResult validateFailed(D data){
        return  new CommonResult<>(ResultCode.VALIDATE_FAILED.getCode(),ResultCode.VALIDATE_FAILED.getMessage(),data);

    }

    public static CommonResult failed() {
        return new CommonResult(ResultCode.FAILED.getCode(),ResultCode.FAILED.getMessage());
    }
    public static CommonResult success(){
        return  new CommonResult(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMessage());
    }
    public static CommonResult validateFailed(){
        return  new CommonResult(ResultCode.VALIDATE_FAILED.getCode(),ResultCode.VALIDATE_FAILED.getMessage());
    }

    public static CommonResult validateFailed(String defaultMessage) {
        return new CommonResult(defaultMessage);
    }
}
