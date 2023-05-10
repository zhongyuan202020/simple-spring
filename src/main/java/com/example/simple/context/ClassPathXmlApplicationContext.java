package com.example.simple.context;

import com.example.simple.beans.BeanDefinition;
import com.example.simple.beans.BeanFactory;
import com.example.simple.beans.SimpleBeanFactory;
import com.example.simple.beans.XmlBeanDefinitionReader;
import com.example.simple.core.ClassPathXmlResource;
import com.example.simple.core.Resource;

/**
 * @author zhaozhongyuan
 * @date 2023/5/10
 */

public class ClassPathXmlApplicationContext implements BeanFactory {


    private BeanFactory beanFactory;


    //构造器获取外部配置，解析出Bean的定义，形成内存映像
    public ClassPathXmlApplicationContext(String fileName) {
        Resource resource = new ClassPathXmlResource(fileName);
        BeanFactory beanFactory = new SimpleBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        xmlBeanDefinitionReader.loadBeanDefinitions(resource);
        this.beanFactory = beanFactory;
    }


    //这是对外的一个方法，让外部程序从容器中获取Bean实例，会逐步演化成核心方法
    @Override
    public Object getBean(String beanName) {
        return this.beanFactory.getBean(beanName);
    }

    @Override
    public Boolean containsBean(String name) {
        return this.beanFactory.containsBean(name);
    }

    @Override
    public void registerBean(String beanName, Object obj) {
        this.beanFactory.registerBean(beanName, obj);
    }

    @Override
    public void registerBeanDefinition(BeanDefinition beanDefinition) {
        this.beanFactory.registerBeanDefinition(beanDefinition);
    }
}
