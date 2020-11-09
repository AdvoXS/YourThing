package com.creation.restobject;


import com.creation.entity.User;
import org.springframework.stereotype.Component;

@Component
public class Auth {

    private String token;
    private User user;

    public Auth() {

    }

    public Auth(String token, User user) {
        this.token = token;
        this.user = user;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
