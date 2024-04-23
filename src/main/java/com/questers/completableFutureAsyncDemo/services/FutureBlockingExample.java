package com.questers.completableFutureAsyncDemo.services;

import java.util.concurrent.*;

public class FutureBlockingExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<String> future = executor.submit(() -> {
            Thread.sleep(2000); // Simulate task that takes time
            return "Blocking result";
        });

        // This will block until the future completes
        String result = future.get();
        System.out.println("Result: " + result);

        executor.shutdown();
    }
}


