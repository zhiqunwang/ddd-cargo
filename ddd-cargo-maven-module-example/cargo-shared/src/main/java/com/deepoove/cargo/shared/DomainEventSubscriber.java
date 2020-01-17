package com.deepoove.cargo.shared;

/**
 * @description: DomainEventSubscriber
 * @date: 2020/1/17 上午10:32
 * @author: wangzhiqun
 * @version: 1.0
 */
public interface DomainEventSubscriber<T> {

    /**
     * handler event
     * @param event
     */
    void handleEvent(T event);

    /**
     * event type
     * @return
     */
    Class<T> subscribedToEventType();
}
