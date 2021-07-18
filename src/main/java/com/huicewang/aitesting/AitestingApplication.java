package com.huicewang.aitesting;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//@MapperScan("com.huicewang.aitesting.mapper")
@SpringBootApplication
public class AitestingApplication {

	public static void main(String[] args) {
		SpringApplication.run(AitestingApplication.class, args);
	}

}
