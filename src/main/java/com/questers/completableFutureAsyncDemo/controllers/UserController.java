package com.questers.completableFutureAsyncDemo.controllers;

import com.questers.completableFutureAsyncDemo.models.UserDetails;
import com.questers.completableFutureAsyncDemo.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{id}")
    public CompletableFuture<UserDetails> getUserDetails(@PathVariable("id") Long userId) {
        return userService.fetchUserDetails(userId);
    }
}
