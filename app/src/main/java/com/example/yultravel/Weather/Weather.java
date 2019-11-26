package com.example.yultravel.Weather;

import android.net.Uri;
import android.widget.ImageView;

public class Weather {
    private String temperature;
    private String date;
    String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Weather(String temp, String date, String imgUrl){
        this.temperature =temp;
        this.date=date;
        this.imageUrl = imgUrl;

    }
    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
