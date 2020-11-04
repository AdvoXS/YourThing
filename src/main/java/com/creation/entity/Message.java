package com.creation.entity;

import java.time.LocalDateTime;

public class Message implements Entity {

    int id;
    User fromUser;
    User toUser;
    LocalDateTime dateMessage;
    String data;
    LocalDateTime created_at;
    LocalDateTime updated_at;

    public Message(){}
    public Message(int id, User fromUser, User toUser, LocalDateTime dateMessage, String data, LocalDateTime created_at, LocalDateTime updated_at) {
        this.id = id;
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.dateMessage = dateMessage;
        this.data = data;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getFromUser() {
        return fromUser;
    }

    public void setFromUser(User fromUser) {
        this.fromUser = fromUser;
    }

    public User getToUser() {
        return toUser;
    }

    public void setToUser(User toUser) {
        this.toUser = toUser;
    }

    public LocalDateTime getDateMessage() {
        return dateMessage;
    }

    public void setDateMessage(LocalDateTime dateMessage) {
        this.dateMessage = dateMessage;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
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
}
