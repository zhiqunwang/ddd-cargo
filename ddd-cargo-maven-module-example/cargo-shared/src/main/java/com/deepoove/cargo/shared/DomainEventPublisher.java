package com.deepoove.cargo.shared;

public interface DomainEventPublisher {

    void publish(Object event);

}
