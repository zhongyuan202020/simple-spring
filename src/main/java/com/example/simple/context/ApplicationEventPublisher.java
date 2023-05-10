package com.example.simple.context;

/**
 *
 * @author zhaozhongyuan
 * @date 2023/5/10
 */
public interface ApplicationEventPublisher {

    void publishEvent(ApplicationEvent event);
}
