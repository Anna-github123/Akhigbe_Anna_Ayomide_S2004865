package com.example.ann_akhigbe_ayomide_s2004865.utilities;

import com.example.ann_akhigbe_ayomide_s2004865.model.data.WeatherData;
import com.example.ann_akhigbe_ayomide_s2004865.model.data.WeatherForecast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


// Name: Anna Akhigbe Ayomide
// StudentId: S2004865
// Programme of Study: Mobile Platform Development
public class WeatherInfoParser {

    public static WeatherData parseWeatherData(InputStream inputStream) throws XmlPullParserException, IOException {
        WeatherData weatherData = null;
        WeatherForecast weatherForecast = null;
        List<WeatherForecast> items = new ArrayList<>();
        boolean isParsingItems = false;
        String text = null;

        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        factory.setNamespaceAware(true);
        XmlPullParser parser = factory.newPullParser();
        parser.setInput(inputStream, null);

        int eventType = parser.getEventType();
        while (eventType != XmlPullParser.END_DOCUMENT) {
            String tagName = parser.getName();
            switch (eventType) {
                case XmlPullParser.START_TAG:
                    if (tagName.equals("channel")) {
                        isParsingItems = false;
                        weatherData = new WeatherData();
                    } else if (tagName.equals("item")) {
                        weatherForecast = new WeatherForecast();
                        isParsingItems = true;
                    }
                    break;

                case XmlPullParser.TEXT:
                    text = parser.getText();
                    break;

                case XmlPullParser.END_TAG:
                    if (tagName.equals("item")) {
                        items.add(weatherForecast);
                    } else if (tagName.equals("channel")) {
                        weatherData.setThreeDaysForecast(items);
                    }
                    if (isParsingItems) {
                        if (tagName.equals("title")) {
                            weatherForecast.setTitle(text);
                        } else if (tagName.equals("description")) {
                            weatherForecast.setDescription(text);
                        } else if (tagName.equals("pubDate")) {
                            weatherForecast.setPublishedOn(text);
                        } else if (tagName.equals("point")) {
                            weatherForecast.setLocationPoints(text);
                        }
                    } else {
                        if (tagName.equals("title")) {
                            weatherData.setTitle(text);
                        } else if (tagName.equals("description")) {
                            weatherData.setDescription(text);
                        } else if (tagName.equals("pubDate")) {
                            weatherData.setPublishedOn(text);
                        }
                    }
                    break;

                default:
                    break;
            }
            eventType = parser.next();
        }
        inputStream.close();

        return weatherData;
    }
}
