package com.example.simple.core;

import com.example.simple.beans.BeanDefinition;
import com.example.simple.beans.BeansException;
import com.example.simple.core.BeanFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhaozhongyuan
 * @date 2023/5/10
 */
public class SimpleBeanFactory implements BeanFactory {

    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();
    private Map<String, Object> singletons = new HashMap<>();


    @Override
    public Object getBean(String beanName) throws BeansException {
        Object singleton = singletons.get(beanName);
        if (singleton == null) {
            //获取Bean的定义
            BeanDefinition beanDefinition = beanDefinitionMap.getOrDefault(beanName, null);
            if (beanDefinition == null) {
                throw new BeansException("No bean named " + beanName + " is defined");
            }
            try {
                singleton = Class.forName(beanDefinition.getClassName()).newInstance();
            } catch (Exception e) {
                throw new BeansException("Instantiation of bean failed", e);
            }
            //注册Bean实例
            singletons.put(beanDefinition.getId(), singleton);
        }
        return singleton;

    }

    @Override
    public void registerBeanDefinition(BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanDefinition.getId(), beanDefinition);
    }

}
