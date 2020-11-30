package com.creation.entity;

import com.google.gson.annotations.SerializedName;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Lazy
public class ShopsList {
    @SerializedName("shops")
    private final ArrayList<Shop> shops;

    public ShopsList() {
        shops = new ArrayList<>();
    }

    public ArrayList<Shop> getUserList() {
        return shops;
    }

}
