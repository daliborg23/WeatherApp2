package org.example.weatherapp.dto;

import org.example.weatherapp.dto.OpenWeatherDtoClasses.Weather;
import org.example.weatherapp.dto.OpenWeatherDtoClasses.Main;
import org.example.weatherapp.dto.OpenWeatherDtoClasses.Wind;

import java.util.ArrayList;
import java.util.List;

public class OpenWeatherDto {
    // weather bude problem je tam pole
    private List<Weather> weather;
    private Main main;
    private Wind wind;
    private long dt;
    private String name;

    // getters
    public List<Weather> getWeather() {
        return weather;
    }
    public Main getMain() {
        return main;
    }
    public Wind getWind() {
        return wind;
    }
    public long getDt() {
        return dt;
    }
    public String getName() {
        return name;
    }

    // setters
    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }
    public void setMain(Main main) {
        this.main = main;
    }
    public void setWind(Wind wind) {
        this.wind = wind;
    }
    public void setDt(long dt) {
        this.dt = dt;
    }
    public void setName(String name) {
        this.name = name;
    }
}

