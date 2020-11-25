package com.creation.entity;

import com.google.gson.annotations.SerializedName;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Lazy
public class AdminsList {
    @SerializedName("admins")
    private final ArrayList<User> admins;

    public AdminsList() {
        admins = new ArrayList<>();
    }

    public ArrayList<User> getUserList() {
        return admins;
    }

}
