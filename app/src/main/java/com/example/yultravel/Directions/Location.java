package com.example.yultravel.Directions;

public class Location {
    private String name;
    private String address;

    public Location(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }
}
