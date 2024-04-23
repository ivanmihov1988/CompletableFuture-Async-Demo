package com.questers.completableFutureAsyncDemo.controllers;

import com.questers.completableFutureAsyncDemo.models.UserActivity;
import com.questers.completableFutureAsyncDemo.services.ActivityService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
public class ActivityController {
    private final ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @PostMapping("/log-activity")
    public CompletableFuture<Void> logActivity(@RequestBody UserActivity activity) {
        return activityService.logActivity(activity);
    }
}
