package com.example.simple.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 默认的单例Bean注册中心
 *
 * @author zhaozhongyuan
 * @date 2023/5/10
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    /**
     * 容器中存放所有bean的名称的列表
     */
    protected List<String> beanNames = new ArrayList<>();
    /**
     * 容器中存放所有bean实例的map
     * 因为要保证单例且并发下的安全，所以这里使用了线程安全的ConcurrentHashMap
     */
    protected final Map<String, Object> singletons = new ConcurrentHashMap<>(256);

    @Override
    public void registerSingleton(String beanName, Object singletonObject) {
        synchronized (this.singletons) {
            this.singletons.put(beanName, singletonObject);
            this.beanNames.add(beanName);
        }
    }
    @Override
    public Object getSingleton(String beanName) {
        return this.singletons.get(beanName);
    }
    @Override
    public boolean containsSingleton(String beanName) {
        return this.singletons.containsKey(beanName);
    }
    @Override
    public String[] getSingletonNames() {
        return this.beanNames.toArray(new String[0]);
    }

    protected void removeSingleton(String beanName) {
        synchronized (this.singletons) {
            this.beanNames.remove(beanName);
            this.singletons.remove(beanName);
        }
    }

}
