package com.creation.entity;

public class ProductCategory implements Entity {
    Category category;
    Product product;

    public ProductCategory(Category category, Product product) {
        this.category = category;
        this.product = product;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
