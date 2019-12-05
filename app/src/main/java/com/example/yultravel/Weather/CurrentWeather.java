package com.example.yultravel.Weather;

public class CurrentWeather {
    private String description;
    private String currentTemp;
    private String currentImgUrl;
    String weatherCondition;

    public CurrentWeather(String description,String temp,String imgUrl){
        this.description=description;
        this.currentTemp=temp;
        this.currentImgUrl=imgUrl;

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCurrentTemp() {
        return currentTemp;
    }

    public void setCurrentTemp(String temp) {
        this.currentTemp = temp;
    }

    public String getCurrentImgUrl() {
        return currentImgUrl;
    }

    public void setCurrentImgUrl(String imgUrl) {
        this.currentImgUrl = imgUrl;
    }

    public String getWeatherCondition() {
        return weatherCondition;
    }


}
