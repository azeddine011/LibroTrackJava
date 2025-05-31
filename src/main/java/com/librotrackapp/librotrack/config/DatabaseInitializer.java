package com.librotrackapp.librotrack.config;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        try {
        } catch (Exception e) {
            System.err.println("Failed to start SSH tunnel: " + e.getMessage());
            throw new RuntimeException("Failed to start SSH tunnel", e);
        }
    }
}
