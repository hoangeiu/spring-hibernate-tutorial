package com.hoangle.springcoredemo.config;

import com.hoangle.springcoredemo.common.Coach;
import com.hoangle.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    @Bean
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
