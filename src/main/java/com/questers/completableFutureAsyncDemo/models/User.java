package com.questers.completableFutureAsyncDemo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class User {
    @Getter
    private Long id;

    @Getter
    private String name;
}
