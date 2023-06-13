package org.example.weatherapp.service;

import org.example.weatherapp.City;
import org.example.weatherapp.connector.OpenWeatherConnector;
import org.example.weatherapp.dto.WeatherDto;
import org.example.weatherapp.dto.OpenWeatherDto;
import org.springframework.stereotype.Service;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Calendar;

import static com.fasterxml.jackson.databind.type.LogicalType.DateTime;

@Service
public class WeatherService {
    public WeatherDto getWeatherForCity(City city) {
        OpenWeatherConnector connector = new OpenWeatherConnector();
        City enumCity = City.valueOf(city.toString().toUpperCase());
        OpenWeatherDto owDto = connector.getWeatherForCity(enumCity);
        return transformDto(owDto);
    }
    private WeatherDto transformDto(OpenWeatherDto owDto){
        WeatherDto wDto = new WeatherDto();
        wDto.setLocation(owDto.getName());
        wDto.setHumidity(owDto.getMain().getHumidity());
        wDto.setTemperature(owDto.getMain().getTemp());
        // zmena casu z UNIX -> CET
        Calendar calendar = Calendar.getInstance();
        long time = owDto.getDt();
        calendar.setTimeInMillis(time * 1000L);
        wDto.setObservation_time(calendar.getTime().toString());
        wDto.setWeather_descriptions(owDto.getWeather().get(0).getDescription());
        wDto.setWind_dir(owDto.getWind().getDeg());
        wDto.setWind_speed(owDto.getWind().getSpeed());
        return wDto;
    }
}

