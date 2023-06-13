package org.example.weatherapp.dto.OpenWeatherDtoClasses;

public class Wind {
    private double speed;
    private double deg;

    // getters
    public double getSpeed() {
        return speed;
    }
    public double getDeg() {
        return deg;
    }

    // setters
    public void setSpeed(double speed) {
        this.speed = speed;
    }
    public void setDeg(double deg) {
        this.deg = deg;
    }
}