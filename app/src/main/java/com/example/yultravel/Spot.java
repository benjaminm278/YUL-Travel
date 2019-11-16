package com.example.yultravel;

public class Spot {
    private String title;

    /**
     *
     * @param spotName
     */
    public Spot(String spotName) {
        this.title = spotName;
    }

    /**
     *
     * @return
     */
    public String getTitle() {
        return this.title;
    }
}
