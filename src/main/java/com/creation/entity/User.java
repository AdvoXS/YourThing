package com.creation.entity;

import java.util.Date;

public class User implements Entity {

    int id;
    String email;
    int phone;
    String firstName;
    String lastName;
    String status;
    Date confirmed_at;
    Date rewiewed_at;
    Date created_at;
    Date updated_at;

    public User() {
    }

    public User(int id, String email, int phone, String firstName, String lastName, String status, Date confirmed_at, Date rewiewed_at, Date created_at, Date updated_at) {
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
        this.confirmed_at = confirmed_at;
        this.rewiewed_at = rewiewed_at;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getConfirmed_at() {
        return confirmed_at;
    }

    public void setConfirmed_at(Date confirmed_at) {
        this.confirmed_at = confirmed_at;
    }

    public Date getRewiewed_at() {
        return rewiewed_at;
    }

    public void setRewiewed_at(Date rewiewed_at) {
        this.rewiewed_at = rewiewed_at;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }
}
