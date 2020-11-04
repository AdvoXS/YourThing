package com.creation.entity;


import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Product implements Entity {

    private int id;
    Shop shop;
    Category category;
    private String pathImage;
    private String title;

    String description;
    private BigDecimal cost;
    private int sale;
    LocalDateTime reviewed_at;
    LocalDateTime created_at ;
    LocalDateTime updated_at;

    public Product(){}
    public Product(int id, Shop shop, Category category, String pathImage, String title, BigDecimal cost, int sale, LocalDateTime reviewed_at, LocalDateTime created_at, LocalDateTime updated_at, String description) {
        this.id = id;
        this.shop = shop;
        this.category = category;
        this.pathImage = pathImage;
        this.title = title;
        this.cost = cost;
        this.sale = sale;
        this.reviewed_at = reviewed_at;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    public LocalDateTime getReviewed_at() {
        return reviewed_at;
    }

    public void setReviewed_at(LocalDateTime reviewed_at) {
        this.reviewed_at = reviewed_at;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
