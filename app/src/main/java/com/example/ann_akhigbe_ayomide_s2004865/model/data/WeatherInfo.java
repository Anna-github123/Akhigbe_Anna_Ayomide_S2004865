package com.example.ann_akhigbe_ayomide_s2004865.model.data;

public class WeatherInfo {

    private final String day;
    private final String weatherCondition;
    private final String minTemperature;
    private String maxTemperature;

    public String getDay() {
        return day;
    }

    public String getWeatherCondition() {
        return weatherCondition;
    }

    public String getMaxTemperature() {
        return maxTemperature;
    }

    public String getMinTemperature() {
        return minTemperature;
    }

    public WeatherInfo(String dataString) {
        String[] parts = dataString.split(", ");
        String[] dayCon = parts[0].split(": ");
        day =  dayCon[0].trim();
        weatherCondition = dayCon[1].trim();
        String[] temp = parts[1].split(": ");
        minTemperature = temp[1].split("°C")[0].trim();
        if(dataString.contains("Maximum Temperature")){
            maxTemperature = temp[2].split("°C")[0].trim();
        }
    }
}
