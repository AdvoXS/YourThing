package com.creation.dataobjects;

import java.math.BigDecimal;

public class Product {

    private String pathImage;

    private String name;

    private BigDecimal price;

    private int sale;

    public Product(String pathImage, String name, BigDecimal price, int sale) {
        this.pathImage = pathImage;
        this.name = name;
        this.price = price;
        this.sale = sale;
    }

    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }
}
