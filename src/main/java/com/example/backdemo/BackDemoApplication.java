package com.example.backdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@MapperScan("com.example.backdemo.mapper")
@EnableAspectJAutoProxy
public class BackDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackDemoApplication.class, args);
    }

}
