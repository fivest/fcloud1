package com.fcloud.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;

/**
 * @author Ruben Fu
 */
public class EventPublisherController {

    @Autowired
    protected ApplicationEventPublisher eventPublisher;

    public void setEventPublisher(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }
}
