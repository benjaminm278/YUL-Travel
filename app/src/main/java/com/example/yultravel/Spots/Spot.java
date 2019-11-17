package com.example.yultravel.Spots;

public class Spot {
    private String title;
    private String description;

    /**
     *
     * @param spotName
     */
    public Spot(String spotName, String description) {
        this.title = spotName;
        this.description = description;
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
}
