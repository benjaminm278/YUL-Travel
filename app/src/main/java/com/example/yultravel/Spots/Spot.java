package com.example.yultravel.Spots;

public class Spot {
    private String title;
    private String description;
    private String url;

    /**
     *
     * @param spotName
     */
    public Spot(String spotName, String description, String url) {
        this.title = spotName;
        this.description = description;
        this.url = url;
    }

    public String getDescription() {
        return this.description;
    }

    /**
     *
     * @return
     */
    public String getTitle() {
        return this.title;
    }

    public String getURL() { return this.url; }
}
