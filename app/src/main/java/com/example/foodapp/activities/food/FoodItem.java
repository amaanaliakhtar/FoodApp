package com.example.foodapp.activities.food;

import java.io.Serializable;

public class FoodItem implements Serializable {
    private String title;
    private String image;
    private String description;
    private double price;
    private int inCart;

    public FoodItem(String title, String image, String description, double price, int inCart) {
        this.title = title;
        this.image = image;
        this.description = description;
        this.price = price;
        this.inCart = inCart;
    }

    public FoodItem(String title, String image, String description, double price) {
        this.title = title;
        this.image = image;
        this.description = description;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getInCart() {
        return inCart;
    }

    public void setInCart(int inCart) {
        this.inCart = inCart;
    }
}
