package com.example.yultravel;

import android.widget.ImageView;

public class Weather {
    private String temperature;
    private String date;

    public String getImageView() {
        return imageView;
    }

    public void setImageView(String imageView) {
        this.imageView = imageView;
    }

    String imageView;


    public Weather(String temp, String date, String imageView){
        this.temperature =temp;
        this.date=date;
        this.imageView =imageView;
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
