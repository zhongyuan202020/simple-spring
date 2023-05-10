package com.example.simple.test;

import com.example.simple.test.AService;

/**
 * @author zhaozhongyuan
 * @date 2023/5/10
 */
public class AServiceImpl implements AService {

    @Override
    public void sayHello() {
        System.out.println("a service 1 say hello");
    }
}
