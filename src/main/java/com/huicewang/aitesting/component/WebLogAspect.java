package com.huicewang.aitesting.component;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Aspect
@Component
@Order(1)
public class WebLogAspect {
    private Logger LOGGER = LoggerFactory.getLogger(WebLogAspect.class);
    @Around("execution(public * com.huicewang.aitesting.controller.*.*(..))")
    public Object getTime(ProceedingJoinPoint joinPoint) throws Throwable {
        Long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        Long endTime = System.currentTimeMillis();
        Long duration = endTime - startTime;
        LOGGER.info("创建时间为："+String.valueOf(duration));
        return result;
    }
}
