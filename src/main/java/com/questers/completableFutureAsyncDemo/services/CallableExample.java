package com.questers.completableFutureAsyncDemo.services;

import java.util.concurrent.*;

public class CallableExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> task = () -> {
            // Simulate some computation
            Thread.sleep(1000);
            return "Result of the Callable";
        };

        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<String> future = executor.submit(task);

        // Do something else while the task is being executed

        // Block and get the result of the Callable
        String result = future.get();
        System.out.println(result);

        executor.shutdown();
    }
}

