package com.deepoove.cargo.infrastructure.event;

import com.deepoove.cargo.shared.DomainEventPublisher;
import com.google.common.eventbus.EventBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @description: GuavaDomainEventPublisher
 * @date: 2020/1/14 下午3:06
 * @author: wangzhiqun
 * @version: 1.0
 */
@Component
public class GuavaDomainEventPublisher implements DomainEventPublisher {
    @Autowired
    EventBus eventBus;

    @Override
    public void publish(Object event) {
        eventBus.post(event);
    }
}
