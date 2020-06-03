package com.soft.b2cshop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Description 启动类
 * @Author ljy
 * @Date 2020/1/16 20:39
 **/
@SpringBootApplication
@ComponentScan(basePackages = {"com.soft"})
@MapperScan(basePackages = "com.soft.mapper")  // 扫描mapper
public class B2cShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(B2cShopApplication.class, args);
        System.out.println("---------------------------------");
        System.out.println("            B2C商城 =====>       ");
        System.out.println("    启动成功 ///(^v^)\\\\~~~     ");
        System.out.println("                                 ");
        System.out.println("---------------------------------");
    }

}
