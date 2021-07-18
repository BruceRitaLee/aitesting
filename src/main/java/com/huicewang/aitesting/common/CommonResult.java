package com.huicewang.aitesting.common;

public class CommonResult<T> {
    private long code;
    private String message;
    private T data;

    public CommonResult(long code, String message, T data) {
    }

    public static<D> CommonResult success(D data){
        return  new CommonResult<>(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMessage(),data);

    }
}
