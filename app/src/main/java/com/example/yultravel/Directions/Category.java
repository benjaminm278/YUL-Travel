package com.example.yultravel.Directions;

public class Category {
    private String name;
    private int imageId;

    public Category(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public String getCategoryName() {
        return this.name;
    }

    public int getImageId() {
        return this.imageId;
    }
}
