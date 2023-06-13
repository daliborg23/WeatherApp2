package org.example.weatherapp.controller;

import org.example.weatherapp.dto.WeatherDto;
import org.example.weatherapp.service.WeatherService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.example.weatherapp.City;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class WeatherController {
    WeatherService ws;
    public WeatherController(){
        ws = new WeatherService();
    }
    @RequestMapping("/weather")
    public Collection<WeatherDto> getWeather() {
        List<WeatherDto> weatherDtoList = new ArrayList<>();
        //WeatherService ws = new WeatherService();
        for (City city : City.values()){
            weatherDtoList.add(ws.getWeatherForCity(city));
        }
        return weatherDtoList;
    }

    @RequestMapping("/weather/{city}")
    public WeatherDto getWeatherForCity(@PathVariable String city) {
        //WeatherService ws = new WeatherService();
        String decodedCityName = URLDecoder.decode(city, StandardCharsets.UTF_8);
        String enumCityName = decodedCityName.replace(" ", "_").toUpperCase();
        return ws.getWeatherForCity(City.valueOf(enumCityName));
    }
}
