package com.example.ann_akhigbe_ayomide_s2004865.model.data;

public class WeatherInfo {

    private String day;
    private String weatherCondition;
    private String minTemperature;
    private int minTemperatureFahrenheit;
    private int minTemperatureCelsius;
    private int maxTemperatureFahrenheit;
    private int maxTemperatureCelsius;
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

    // Constructor
//    public WeatherInfo(String day, String weatherCondition, int minTemperatureCelsius, int minTemperatureFahrenheit,
//                       int maxTemperatureCelsius, int maxTemperatureFahrenheit) {
//        this.day = day;
//        this.weatherCondition = weatherCondition;
//        this.minTemperatureCelsius = minTemperatureCelsius;
//        this.minTemperatureFahrenheit = minTemperatureFahrenheit;
//        this.maxTemperatureCelsius = maxTemperatureCelsius;
//        this.maxTemperatureFahrenheit = maxTemperatureFahrenheit;
//    }

    // Sample method to parse string and create WeatherInfo object
//    public static WeatherInfo parseString(String input) {
//        String[] parts = input.split(", ");
//        String day = parts[0].split(": ")[0];
//        String weatherCondition = parts[0].split(": ")[1];
//        int minTempCelsius = Integer.parseInt(parts[1].split(": ")[1].split("°C")[0].trim());
//        int minTempFahrenheit = Integer.parseInt(parts[1].split("\\(")[1].split("°F")[0].trim());
//        int maxTempCelsius = Integer.parseInt(parts[2].split(": ")[1].split("°C")[0].trim());
//        int maxTempFahrenheit = Integer.parseInt(parts[2].split("\\(")[1].split("°F")[0].trim());
//
//        return new WeatherInfo(day, weatherCondition, minTempCelsius, minTempFahrenheit, maxTempCelsius, maxTempFahrenheit);
//    }

    // Method to parse the string and create a TemperatureRange object




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
