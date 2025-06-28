package com.example.hitcapp;


public class Product {
    private String name;
    private String price;
    private int imageResId;
    private String category;  // Added category field

    // Constructor that accepts name, price, imageResId, and category
    public Product(String name, String price, int imageResId, String category) {
        this.name = name;
        this.price = price;
        this.imageResId = imageResId;
        this.category = category;  // Initialize category
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public int getImageResId() {
        return imageResId;
    }

    // Getter for category
    public String getCategory() {
        return category;
    }
}
