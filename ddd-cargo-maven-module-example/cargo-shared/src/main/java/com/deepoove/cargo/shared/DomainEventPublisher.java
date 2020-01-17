package com.deepoove.cargo.shared;

public interface DomainEventPublisher<T> {

    void publish(final T event);

}
