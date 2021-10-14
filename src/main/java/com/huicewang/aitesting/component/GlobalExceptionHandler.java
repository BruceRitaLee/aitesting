package com.huicewang.aitesting.component;

import cn.dev33.satoken.exception.NotLoginException;
import com.huicewang.aitesting.common.CommonResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = NotLoginException.class)
    public CommonResult handleNotLoginException(NotLoginException e){
        return CommonResult.unauthorizen(e.getMessage());
    }

}
