package com.huicewang.aitesting.common;

import lombok.Getter;

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
    public static<D> CommonResult validate_failed(D data){
        return  new CommonResult<>(ResultCode.VALIDATE_FAILED.getCode(),ResultCode.VALIDATE_FAILED.getMessage(),data);

    }

}
