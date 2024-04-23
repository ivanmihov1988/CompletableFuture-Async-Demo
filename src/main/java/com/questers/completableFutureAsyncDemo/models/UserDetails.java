package com.questers.completableFutureAsyncDemo.models;

import lombok.Getter;
import lombok.Setter;

public class UserDetails {
    @Getter
    private Long id;

    @Getter
    private String name;

    @Getter
    private String email;

    @Getter
    @Setter
    private String preferences;

    @Getter
    @Setter
    private Integer score;

    public UserDetails(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}