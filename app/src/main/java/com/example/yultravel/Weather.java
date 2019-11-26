package com.example.yultravel;

import android.net.Uri;
import android.widget.ImageView;

public class Weather {
    private String temperature;
    private String date;
    private String imageUrl;

    String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    Weather(String temp, String date, String imgUrl){
        this.temperature =temp;
        this.date=date;
        this.imageUrl = imgUrl;

    }
    String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
