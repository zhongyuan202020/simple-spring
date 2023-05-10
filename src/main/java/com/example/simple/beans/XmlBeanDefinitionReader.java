package com.example.simple.beans;

import com.example.simple.beans.BeanDefinition;
import com.example.simple.beans.BeanFactory;
import com.example.simple.core.Resource;
import org.dom4j.Element;

/**
 * XML Reader，将xml读取后，解析后的BeanDefinition放到BeanFactory里面
 * @author zhaozhongyuan
 * @date 2023/5/10
 */
public class XmlBeanDefinitionReader {

    private BeanFactory beanFactory;

    public XmlBeanDefinitionReader(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public void loadBeanDefinitions(Resource resource) {
        while (resource.hasNext()) {
            Element element = (Element) resource.next();
            String beanID = element.attributeValue("id");
            String beanClassName = element.attributeValue("class");
            BeanDefinition beanDefinition = new BeanDefinition(beanID, beanClassName);
            this.beanFactory.registerBeanDefinition(beanDefinition);
        }
    }
}
