package com.example.simple.context;

import java.util.EventObject;

/**
 * 监听容器的事件
 * 继承 EventObject，后续就方便使用观察者模式
 * @author zhaozhongyuan
 * @date 2023/5/10
 */
public class ApplicationEvent extends EventObject {

    public ApplicationEvent(Object source) {
        super(source);
    }
}
