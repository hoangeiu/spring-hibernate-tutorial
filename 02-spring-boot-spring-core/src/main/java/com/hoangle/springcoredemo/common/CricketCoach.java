package com.hoangle.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// @Component annotation marks the class as a Spring bean, make it available for DI
@Component
//@Primary
//@Lazy
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements Coach {
    public CricketCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    // define our init method
    @PostConstruct
    public void onInit() {
        System.out.println("In onInit(): " + getClass().getSimpleName());
    }

    // define our destroy method
    @PreDestroy
    public void onDestroy() {
        System.out.println("In onDestroy(): " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes!!!";
    }
}
