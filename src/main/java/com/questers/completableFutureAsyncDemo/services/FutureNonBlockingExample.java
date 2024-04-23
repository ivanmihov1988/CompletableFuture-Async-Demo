package com.questers.completableFutureAsyncDemo.services;

import java.util.concurrent.*;

public class FutureNonBlockingExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<String> future = executor.submit(() -> {
            Thread.sleep(2000); // Simulate task that takes time
            return "Result";
        });

        while (!future.isDone()) {
            System.out.println("Waiting for the future to complete...");
            Thread.sleep(100); // Do something else instead of just blocking
        }

        System.out.println("Result: " + future.get()); // Now we can safely block
        executor.shutdown();
    }
}

