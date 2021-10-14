package com.huicewang.aitesting.component;

import com.huicewang.aitesting.common.CommonResult;
import com.huicewang.aitesting.controller.UserController;
import io.swagger.annotations.ApiOperation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.lang.reflect.Method;

@Aspect
@Component
@Order(1)
public class BindingResultAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(BindingResultAspect.class);
    @Pointcut("execution(public * com.huicewang.aitesting.controller.*.*(..))")
    public void bindingResult(){
    }

    /**
     * 验证数据库字段参数是否合法，同时返回相应的结果
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("bindingResult()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {

        //---------------------------------------------------
//        Signature signature = joinPoint.getSignature();//获取切点的方法签名
//        MethodSignature methodSignature = (MethodSignature) signature;
//        Method method = methodSignature.getMethod();// 获取方法对象
//        if (method.isAnnotationPresent(ApiOperation.class)){
//            ApiOperation apiOperation = method.getAnnotation(ApiOperation.class);
//            LOGGER.info(apiOperation.value());// 获取切点方法的ApiOperation注解的文字信息
//        }
        //-----------------------------------------------------


        // 获取切点的所有参数
        Object[] args = joinPoint.getArgs(); // user result
        // 获取BindingResult参数
        for (Object arg : args) {
            // 判断arg的类型是否为BindingResult
            if (arg instanceof BindingResult){
                BindingResult result = (BindingResult) arg;

                if(result.hasErrors()){
                    // 获取错误的字段信息
                    FieldError fieldError = result.getFieldError();
                    if(fieldError != null){
                        return CommonResult.validateFailed(fieldError.getDefaultMessage());
                    }else {
                        return CommonResult.validateFailed();
                    }
                }
            }
        }

        return joinPoint.proceed();// 参数合法
    }
}
