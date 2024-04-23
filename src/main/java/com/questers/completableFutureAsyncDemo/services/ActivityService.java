package com.questers.completableFutureAsyncDemo.services;

import com.questers.completableFutureAsyncDemo.models.UserActivity;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class ActivityService {
    public CompletableFuture<Void> logActivity(UserActivity activity) {
        return CompletableFuture.runAsync(() -> {
            // Simulate updating activity to a database
            System.out.println("Update activity in db: " + Thread.currentThread().getName());

            try {
                Thread.sleep(1000); // Simulate delay
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).thenRunAsync(() -> sendNotification(activity));
    }

    private void sendNotification(UserActivity activity) {
        // Simulate sending a notification after logging the activity
        // This is also an asynchronous operation
        System.out.println("Sending notification for updated activity: " + Thread.currentThread().getName());
    }
}
