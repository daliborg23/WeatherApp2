package org.example.weatherapp.dto;

import java.util.ArrayList;

public class WeatherDto {
    private String location;
    private String observation_time;
    private double temperature;
    private String weather_descriptions;
    private double wind_speed;
    private double wind_dir;
    private double humidity;

    // getters
    public String getLocation() {
        return location;
    }
    public String getObservation_time() {
        return observation_time;
    }
    public double getTemperature() {
        return temperature;
    }
    public String getWeather_descriptions() {
        return weather_descriptions;
    }
    public double getWind_speed() {
        return wind_speed;
    }
    public double getWind_dir() {
        return wind_dir;
    }
    public double getHumidity() {
        return humidity;
    }

    // setters
    public void setLocation(String location) {
        this.location = location;
    }
    public void setObservation_time(String observation_time) {
        this.observation_time = observation_time;
    }
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
    public void setWeather_descriptions(String weather_descriptions) {
        this.weather_descriptions = weather_descriptions;
    }
    public void setWind_speed(double wind_speed) {
        this.wind_speed = wind_speed;
    }
    public void setWind_dir(double wind_dir) {
        this.wind_dir = wind_dir;
    }
    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }
}