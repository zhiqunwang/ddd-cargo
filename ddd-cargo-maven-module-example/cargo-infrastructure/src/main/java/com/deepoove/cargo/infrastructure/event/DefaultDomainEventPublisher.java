package com.deepoove.cargo.infrastructure.event;

import com.deepoove.cargo.shared.DomainEventPublisher;
import com.deepoove.cargo.shared.DomainEventSubscriber;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: default event
 * @date: 2020/1/17 上午10:19
 * @author: wangzhiqun
 * @version: 1.0
 */
@Component("defaultDomainEventPublisher")
public class DefaultDomainEventPublisher<T>  implements DomainEventPublisher<T> {
    /**
     * event subscribers
     */
    private static final ThreadLocal<List> subscribers = new ThreadLocal<List>();

    /**
     * event publish
     */
    private static final ThreadLocal<Boolean> publishing = new ThreadLocal<Boolean>(){
        @Override
        protected Boolean initialValue() {
            return Boolean.FALSE;
        }
    };

    public static DefaultDomainEventPublisher instance(){
        return new DefaultDomainEventPublisher();
    }

    public DefaultDomainEventPublisher(){
        super();
    }

    @Override
    public void publish(final T aEvent) {
        if(publishing.get()){
            return;
        }
        publishing.set(Boolean.TRUE);
        try{
            List<DomainEventSubscriber<T>> registerSubscribers = subscribers.get();
            if(!CollectionUtils.isEmpty(registerSubscribers)){
                for (DomainEventSubscriber<T> subscriber:registerSubscribers){
                    if(subscriber.subscribedToEventType() == aEvent.getClass()){
                        subscriber.handleEvent(aEvent);
                    }
                }
            }
        }finally {
            publishing.set(Boolean.FALSE);
        }
    }

    public DefaultDomainEventPublisher reset(){
        if(!publishing.get()){
            subscribers.set(null);
        }
        return this;
    }

    /**
     * register subscribe
     * @param aSubscriber
     * @param <T>
     */
    public <T> void subscribe(DomainEventSubscriber<T> aSubscriber){
        if(!publishing.get()){
            List<DomainEventSubscriber<T>> registerSubscribers =  subscribers.get();
            if(registerSubscribers==null){
                registerSubscribers = new ArrayList<>();
                subscribers.set(registerSubscribers);
            }else{
                registerSubscribers.add(aSubscriber);
            }
        }

    }
}
