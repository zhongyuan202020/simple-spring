package com.example.simple.beans;

/**
 * 单例的Bean的注册功能
 * @author zhaozhongyuan
 * @date 2023/5/10
 */

public interface SingletonBeanRegistry {

    void registerSingleton(String beanName, Object singletonObject);

    Object getSingleton(String beanName);

    boolean containsSingleton(String beanName);

    String[] getSingletonNames();
}
