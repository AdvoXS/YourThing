package com.creation.service;

import com.creation.entity.User;
import com.google.gson.annotations.SerializedName;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Lazy
public class UsersList {
    @SerializedName("users")
    private final ArrayList<User> users;

    public UsersList() {
        users = new ArrayList<>();
    }

    public ArrayList<User> getUserList() {
        return users;
    }

}
