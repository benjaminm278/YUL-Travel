package com.example.yultravel.Spots;

public class Spot {
    private String title;
    private String description;
    private String url;
    private String address;

    /**
     *
     * @param spotName
     */
    public Spot(String spotName, String description, String url, String address) {
        this.title = spotName;
        this.description = description;
        this.url = url;
        this.address = address;
    }

    public String getDescription() {
        return this.description;
    }

    public String getTitle() {
        return this.title;
    }

    public String getURL() { return this.url; }

    public String getAddress() {
        return this.address;
    }
}
