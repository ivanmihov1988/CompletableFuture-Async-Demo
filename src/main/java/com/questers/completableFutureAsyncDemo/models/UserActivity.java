package com.questers.completableFutureAsyncDemo.models;

import lombok.Getter;

public class UserActivity {
    @Getter
    private String userId;

    @Getter
    private String action;

    public UserActivity(String userId, String action) {
        this.userId = userId;
        this.action = action;
    }
}
