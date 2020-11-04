package com.creation.entity;

import java.time.LocalDateTime;

public class Comment implements Entity {
    int id;
    User user;
    Entity entityCommended;
    int idEntity;
    String comment;
    LocalDateTime created_at;
    LocalDateTime updated_at;

    public Comment(int id, User user, Entity entityCommended, int idEntity, String comment, LocalDateTime created_at, LocalDateTime updated_at) {
        this.id = id;
        this.user = user;
        this.entityCommended = entityCommended;
        this.idEntity = idEntity;
        this.comment = comment;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Entity getEntityCommended() {
        return entityCommended;
    }

    public void setEntityCommended(Entity entityCommended) {
        this.entityCommended = entityCommended;
    }

    public int getIdEntity() {
        return idEntity;
    }

    public void setIdEntity(int idEntity) {
        this.idEntity = idEntity;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
