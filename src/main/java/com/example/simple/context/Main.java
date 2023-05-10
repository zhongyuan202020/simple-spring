package com.example.simple.context;

import com.example.simple.test.AService;

/**
 * @author zhaozhongyuan
 * @date 2023/5/10
 */
public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        AService aService = (AService) context.getBean("aService");
        aService.sayHello();
    }
}
