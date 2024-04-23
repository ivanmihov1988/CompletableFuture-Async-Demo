package com.questers.completableFutureAsyncDemo.services;

import com.questers.completableFutureAsyncDemo.models.UserDetails;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class UserService {
    private final Utils utils;
    private final ExecutorService customExecutor;

    public UserService(Utils utils) {
        this.utils = utils;
        this.customExecutor = Executors.newFixedThreadPool(10);
    }

    public CompletableFuture<UserDetails> fetchUserDetails(Long userId) {
        CompletableFuture<UserDetails> userDetailsTask = CompletableFuture.supplyAsync(() -> {
            System.out.println("Fetch user details thread: " + Thread.currentThread().getName());
            // Simulate fetching user details from a database
            utils.simulateSlowService(3000L);

            return new UserDetails(userId, "John Doe", "johndoe@example.com");
        }, customExecutor).thenApplyAsync(userDetails -> {
            // Simulate enriching user details with preferences asynchronously

            System.out.println("Set user preferences thread: " + Thread.currentThread().getName());
            userDetails.setPreferences(fetchUserPreferences(userId));

            return userDetails;
        }, customExecutor);

        System.out.println("UserService between completable futures calls...");

        CompletableFuture<Integer> userScore = CompletableFuture.supplyAsync(() -> {
            // Simulate fetching user score from a database
            utils.simulateSlowService(2000L);

            System.out.println("Fetch user score thread: " + Thread.currentThread().getName());

            return this.getUserScore(userId);
        }, customExecutor).thenComposeAsync(score -> {
            // Simulate verifying user score in an external system
            utils.simulateSlowService(2000L);

            System.out.println("Verifying user score: " + Thread.currentThread().getName());

            return CompletableFuture.completedFuture(score);
        }, customExecutor);

        System.out.println("UserService before thenCombine...");

        CompletableFuture<UserDetails> finalUserDetails = userDetailsTask.thenCombineAsync(userScore, (userDetails, score) -> {
            userDetails.setScore(score);

            System.out.println("Combine user details thread: " + Thread.currentThread().getName());

            return userDetails;
        }, customExecutor);

        return finalUserDetails;
    }

    private String fetchUserPreferences(Long userId) {
        // Simulate fetching user preferences
        // This can be replaced with an actual database call
        utils.simulateSlowService(2000L);

        return "Dark mode, Email notifications";
    }

    private Integer getUserScore(Long userId) {
        utils.simulateSlowService(1000L);

        return (int) (Math.random() * 101); // Simulate generating a score
    }
}
