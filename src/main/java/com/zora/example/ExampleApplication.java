package com.zora.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//MapperScan注解会在SpringBoot启动的时候扫描mapper包，并根据xml自动生成对应的实现类
@MapperScan("com.zora.example.mapper")
public class ExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExampleApplication.class, args);
    }
}
