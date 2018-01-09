package com.tangmo.shengmei;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ServletComponentScan
@MapperScan("com.tangmo.shengmei.dao")
@PropertySource(value = { "classpath:prop/path.properties"})
public class ShengmeiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShengmeiApplication.class, args);
	}
}
