package com.example.yultravel.Spots;

public class Spot {
    private String title;
    private String description;
    private String url;
    private String address;
    private String imgUrl;



    /**
     *
     * @param spotName
     */
    public Spot(String spotName, String description, String url, String address,String imgUrl) {
        this.title = spotName;
        this.description = description;
        this.url = url;
        this.address = address;
        this.imgUrl = imgUrl;
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
    public String getImgUrl() { return imgUrl; }
}
