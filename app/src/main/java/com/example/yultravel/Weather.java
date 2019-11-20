package com.example.yultravel;

public class Weather {
    private String temperature;
    private String date;

    public Weather(String temp,String date){
        this.temperature =temp;
        this.date=date;
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
