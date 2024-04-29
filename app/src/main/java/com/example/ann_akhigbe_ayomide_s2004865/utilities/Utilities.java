package com.example.ann_akhigbe_ayomide_s2004865.utilities;

import com.example.ann_akhigbe_ayomide_s2004865.R;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;


// Name: Anna Akhigbe Ayomide
// StudentId: S2004865
// Programme of Study: Mobile Platform Development
public class Utilities {

    /**
     * Returns an image denoting the time of the day, and also a greeting of Good morning, afternoon,
     * night or evening
     */
    public static int getGreetingsImage() {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);

        if (hour >= 0 && hour <= 11) {
            return R.drawable.good_morning;
        } else if (hour >= 12 && hour <= 15) {
            return R.drawable.good_afternoon;
        } else if (hour >= 16 && hour <= 20) {
            return R.drawable.good_evening;
        } else if (hour >= 21 && hour <= 23) {
            return R.drawable.good_night;
        } else {
            return R.drawable.hi_there;
        }
    }

    public static String getCurrentDate(){
        // Get the current date
        String formattedDate = "";
        LocalDate currentDate = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            currentDate = LocalDate.now();
        }

        // Create a formatter for the desired format
        DateTimeFormatter formatter = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
        }

        // Format the current date using the formatter
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
           formattedDate = currentDate.format(formatter);
        }
        return  formattedDate;
    }

    public static int getTempsImage(String cloudCondition) {

         int cloud;

        switch (cloudCondition) {
            case "Light Rain":
                cloud = R.drawable.rain;
                break;
            case "Clear Sky":
                cloud = R.drawable.cloudy;
                break;
            case "Drizzle":
                cloud = R.drawable.dri_sleet;
                break;
            case "Light Cloud":
                cloud = R.drawable.overcast;
                break;
            case "Light Rain Showers":
                cloud = R.drawable.day_rain;
                break;
            case "Heavy Rain Showers":
                cloud = R.drawable.heavy_rain_thunder;
                break;
            case "Sunny Intervals":
                cloud = R.drawable.sunny_interval_cloud;
                break;
            default:
                cloud = R.drawable.day_clear;
                break;
        }

        return cloud;


    }

    public static int getBackGroundImage(String city) {

        int cityBg;

        switch (city) {
            case "Dhaka, BD":
                cityBg = R.drawable.dhaka;
                break;
            case "Louis, MU":
                cityBg= R.drawable.mauritus;
                break;
            case "Muscat, OM":
                cityBg = R.drawable.muskat;
                break;
            case "York, US":
                cityBg = R.drawable.new_york;
                break;
            case "Glasgow, GB":
                cityBg = R.drawable.glasgow;
                break;
            default:
                cityBg = R.drawable.london;
                break;
        }

        return cityBg;


    }

    // Returns a particular theme depending on the time of the day
    public static int getApplicationTheme() {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);

        if (hour >= 0 && hour <= 11) {
            return R.style.Theme_WeatherApplication;
        } else if (hour >= 12 && hour <= 15) {
            return R.style.Theme_WeatherApplication_GoodAfternoon;
        } else if (hour >= 16 && hour <= 20) {
            return R.style.Theme_WeatherApplication_GoodEvening;
        } else if (hour >= 21 && hour <= 23) {
            return R.style.Theme_WeatherApplication_GoodNight;
        } else {
            return R.style.Theme_WeatherApplication_GoodAfternoon;
        }
    }

    // Changes the background of the mainView also based on the time of the day
    public static int getMainViewColor() {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);

        if (hour >= 0 && hour <= 11) {
            return R.color.good_morning;
        } else if (hour >= 12 && hour <= 15) {
            return R.color.good_afternoon;
        } else if (hour >= 16 && hour <= 20) {
            return R.color.good_evening;
        } else if (hour >= 21 && hour <= 23) {
            return R.color.good_night;
        } else {
            return R.color.good_afternoon;
        }
    }

}
