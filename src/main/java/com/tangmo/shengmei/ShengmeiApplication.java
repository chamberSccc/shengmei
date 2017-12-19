package com.tangmo.shengmei;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
@MapperScan("com.tangmo.shengmei.dao")
public class ShengmeiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShengmeiApplication.class, args);
	}
}
