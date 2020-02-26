package com.bus.train.service;

import org.springframework.stereotype.Component;

@Component
public class GreetingService {

    public void logGreetingDetails(String greeter, String personToBeGreeted) {
        System.out.println(greeter + " greets " + personToBeGreeted);
    }
    
}