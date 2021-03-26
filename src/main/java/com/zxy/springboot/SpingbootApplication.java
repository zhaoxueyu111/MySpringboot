package com.zxy.springboot;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.zxy.springboot")
public class SpingbootApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpingbootApplication.class, args);
        System.out.println("系统启动成功\n");
        System.out.println("路径为：localhost:8080/Login.html");
    }
}
