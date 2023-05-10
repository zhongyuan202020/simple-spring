package com.example.simple.core;

import com.example.simple.beans.BeanDefinition;
import com.example.simple.beans.BeansException;

/**
 * Bean 工厂
 * @author zhaozhongyuan
 * @date 2023/5/10
 */
public interface BeanFactory {

    Object getBean(String beanName) throws BeansException;

    void registerBeanDefinition(BeanDefinition beanDefinition);
}
