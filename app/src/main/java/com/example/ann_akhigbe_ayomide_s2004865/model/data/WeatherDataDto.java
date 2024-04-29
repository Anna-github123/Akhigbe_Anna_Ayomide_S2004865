package com.example.ann_akhigbe_ayomide_s2004865.model.data;

public class WeatherDataDto {
    private String maxTemperature;
    private String minTemperature;
    private String windDirection;
    private String windSpeed;
    private String visibility;
    private String pressure;
    private String humidity;
    private String uvRisk;
    private String pollution;
    private String sunrise;
    private String sunset;

    public String getHumidity() {
        return humidity;
    }

    public WeatherDataDto(String dataString) {
        String[] parts = dataString.split(", ");

        for (String part : parts) {
            String[] keyValue = part.split(": ");
            String key = keyValue[0].trim();
            String value = keyValue[1].trim();

            switch (key) {
                case "Maximum Temperature":
                    maxTemperature = value;
                    break;
                case "Minimum Temperature":
                    minTemperature = value;
                    break;
                case "Wind Direction":
                    windDirection = value;
                    break;
                case "Wind Speed":
                    windSpeed = value;
                    break;
                case "Visibility":
                    visibility = value;
                    break;
                case "Pressure":
                    pressure = value;
                    break;
                case "Humidity":
                    humidity = value;
                    break;
                case "UV Risk":
                    uvRisk = value;
                    break;
                case "Pollution":
                    pollution = value;
                    break;
                case "Sunrise":
                    sunrise = value;
                    break;
                case "Sunset":
                    sunset = value;
                    break;
            }
        }
    }
}