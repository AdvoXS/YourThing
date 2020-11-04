package com.creation.entity;

import java.time.LocalDateTime;

public class Shop implements Entity {

    int id;
    String name;
    String description;
    LocalDateTime rewiewed_at;
    LocalDateTime created_at;
    LocalDateTime updated_at;
    User owner;

    public Shop(int id, String name, String description, LocalDateTime rewiewed_at, LocalDateTime created_at, LocalDateTime updated_at, User owner) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.rewiewed_at = rewiewed_at;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getRewiewed_at() {
        return rewiewed_at;
    }

    public void setRewiewed_at(LocalDateTime rewiewed_at) {
        this.rewiewed_at = rewiewed_at;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
