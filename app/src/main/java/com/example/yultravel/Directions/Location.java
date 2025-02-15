package com.example.yultravel.Directions;

public class Location {
    private String name;
    private String description;
    private String address;

    public Location(String name, String description, String address) {
        this.name = name;
        this.description = description;
        this.address = address;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String getAddress() {
        return this.address;
    }
}
