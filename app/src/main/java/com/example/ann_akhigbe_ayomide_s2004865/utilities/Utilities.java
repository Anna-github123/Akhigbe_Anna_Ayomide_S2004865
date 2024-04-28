package com.example.ann_akhigbe_ayomide_s2004865.utilities;

import com.example.ann_akhigbe_ayomide_s2004865.R;

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
