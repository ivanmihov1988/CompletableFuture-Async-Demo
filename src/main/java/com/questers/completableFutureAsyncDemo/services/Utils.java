package com.questers.completableFutureAsyncDemo.services;

import org.springframework.stereotype.Component;

@Component
public class Utils {
    public void simulateSlowService(Long milliSeconds) {
        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
