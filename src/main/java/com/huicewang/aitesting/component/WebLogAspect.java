package com.huicewang.aitesting.component;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.condition.RequestConditionHolder;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@Aspect
@Component
@Order(1)
public class WebLogAspect {
    private Logger LOGGER = LoggerFactory.getLogger(WebLogAspect.class);

    @Before("execution(public * com.huicewang.aitesting.controller.*.*(..))")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if(attributes==null){
            return;
        }
        HttpServletRequest request= attributes.getRequest();
        String ip = request.getRemoteAddr();
        String time = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss").format(new Date());
        String target = joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName();
        LOGGER.info(String.format("用户[%s]---在[%s]访问了[%s]",ip,time,target));



    }
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
