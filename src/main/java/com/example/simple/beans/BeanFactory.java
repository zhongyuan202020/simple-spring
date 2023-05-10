package com.example.simple.beans;

import com.example.simple.beans.BeanDefinition;
import com.example.simple.beans.BeansException;

/**
 * Bean 工厂
 * @author zhaozhongyuan
 * @date 2023/5/10
 */
public interface BeanFactory {

    Object getBean(String beanName) throws BeansException;


    Boolean containsBean(String name);

    void registerBean(String beanName, Object obj);

    void registerBeanDefinition(BeanDefinition beanDefinition);
}
