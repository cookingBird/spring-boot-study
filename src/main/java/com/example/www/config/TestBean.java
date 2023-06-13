package com.example.www.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class TestBean {

    public TestBean() {
        System.out.println("TestBean init......................");
    }

    void say(){
        System.out.println("Test Bean say .....................");
    }
}
