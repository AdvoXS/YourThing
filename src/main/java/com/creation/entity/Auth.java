package com.creation.entity;

import org.springframework.stereotype.Component;

@Component
public class Auth {
    boolean isOperator;

    User owner;

    private String token;

    public Auth() {
    }

    public User getUser() {
        return owner;
    }

    public void setUser(User user) {
        this.owner = user;
    }

    public Auth(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isOperator() {
        return isOperator;
    }

    public void setOperator(boolean operator) {
        isOperator = operator;
    }
}
