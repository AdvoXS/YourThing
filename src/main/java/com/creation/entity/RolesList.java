package com.creation.entity;

import com.google.gson.annotations.SerializedName;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Lazy
public class RolesList {
    @SerializedName("role")

    private final ArrayList<Role> roles;

    public RolesList() {
        roles = new ArrayList<>();
    }

    public ArrayList<Role> getUserList() {
        return roles;
    }
}
