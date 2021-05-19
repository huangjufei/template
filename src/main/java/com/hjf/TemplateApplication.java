package com.hjf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.hjf.**.dao")
@SpringBootApplication//里面包含3个注解,启动自动配置
/**
 * 这个类的作用:配置和启动引导的作用
 */
public class TemplateApplication {
    public static void main(String[] args) {
        //启动引导,它会把当前程序当作一个可执行的jar文件来运行
        SpringApplication.run(TemplateApplication.class, args);
    }
}
