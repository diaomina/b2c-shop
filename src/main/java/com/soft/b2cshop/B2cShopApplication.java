package com.soft.b2cshop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.soft"})
@MapperScan(basePackages = "com.soft.mapper")  // 扫描mapper
public class B2cShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(B2cShopApplication.class, args);
    }

}
