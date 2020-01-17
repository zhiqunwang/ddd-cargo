package com.deepoove.cargo.application.service;

import org.springframework.transaction.annotation.Transactional;

/**
 * @description: notify service
 * @date: 2020/1/17 下午3:09
 * @author: wangzhiqun
 * @version: 1.0
 */
public class NotificationService {

    /**
     * 向外部限界上下文发布领域事件
     */
    @Transactional(rollbackFor = Exception.class)
    public void publishNotifications(){

    }
}
