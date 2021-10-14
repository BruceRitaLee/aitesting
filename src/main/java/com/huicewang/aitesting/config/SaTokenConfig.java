package com.huicewang.aitesting.config;

import cn.dev33.satoken.interceptor.SaRouteInterceptor;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Collections;
import java.util.List;

/**
 * Sa-Token相关配置
 * Sa-Token的Java配置类SaTokenConfig，注册一个路由拦截器SaRouteInterceptor，
 * IgnoreUrlsConfig配置会从配置文件中读取白名单配置；
 */
@Configuration
public class SaTokenConfig implements WebMvcConfigurer {

    @Autowired
    private IgnoreUrlsConfig ignoreUrlsConfig;
    private static final Logger Logger = LoggerFactory.getLogger(SaTokenConfig.class);


    /**
     * 注册sa-token拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SaRouteInterceptor((req, resp, handler) -> {
            // 获取配置文件中的白名单路径
            List<String> ignoreUrls = ignoreUrlsConfig.getUrls();
            //Logger.info(String.valueOf(ignoreUrls));
            // 登录认证：除白名单路径外均需要登录认证
            SaRouter.match(Collections.singletonList("/**"), ignoreUrls, StpUtil::checkLogin);
        })).addPathPatterns("/**");
    }

   

}