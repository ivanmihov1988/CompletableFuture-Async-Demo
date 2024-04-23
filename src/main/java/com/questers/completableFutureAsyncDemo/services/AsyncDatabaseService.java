package com.questers.completableFutureAsyncDemo.services;

import com.questers.completableFutureAsyncDemo.models.User;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class AsyncDatabaseService {
    private final Utils utils;

    public AsyncDatabaseService(Utils utils) {
        this.utils = utils;
    }

    @Async
    public CompletableFuture<User> findEntityById(Long id) {
        // EntityManager is used to find the entity

        utils.simulateSlowService(2000L);

        return CompletableFuture.completedFuture(new User(id, "John Doe"));
    }
}