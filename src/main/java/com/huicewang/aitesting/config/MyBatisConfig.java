package com.huicewang.aitesting.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.huicewang.aitesting.mapper")
public class MyBatisConfig {

}
