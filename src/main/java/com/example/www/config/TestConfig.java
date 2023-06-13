package com.example.www.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

    public TestConfig(){
        System.out.println("TestConfiguration容器启动初始化。。。");
    }
}
