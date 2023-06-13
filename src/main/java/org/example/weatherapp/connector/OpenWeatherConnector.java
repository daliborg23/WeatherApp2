package org.example.weatherapp.connector;

import org.example.weatherapp.City;
import org.example.weatherapp.dto.OpenWeatherDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import java.net.URI;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class OpenWeatherConnector {
    //http://api.weatherstack.com/current?access_key=44a4d5ed4b0a589495354db4b0f8dd0b&query=Cesky%20Tesin
    //https://api.openweathermap.org/data/2.5/weather?q=Cesky%20Tesin&appid=86ffa837acb62d38e6fc001a672def7a
    private static final String baseURL = "https://api.openweathermap.org/";
    private static final String urlParams = "data/2.5/weather?q=";
    private static final String url = baseURL+urlParams;
    private static final String APIkey = "&appid=86ffa837acb62d38e6fc001a672def7a";

    public OpenWeatherDto getWeatherForCity(City city){
        URI uri = null;
        RestTemplate template = new RestTemplate();
        try {
            //String encodedCity = URLEncoder.encode(city.toString(), StandardCharsets.UTF_8.toString());
            //uri = new URI(url + ecodedCity + APIkey);
            String decodedCity = URLDecoder.decode(city.toString(), StandardCharsets.UTF_8);
            decodedCity = decodedCity.replace("_","%20");
            uri = new URI(url + decodedCity + APIkey);
        }
        catch (Exception e) {
            System.out.println("Something is wrong!\n" + uri + "\nException: " + e.getMessage());
        }
        ResponseEntity<OpenWeatherDto> response = template.getForEntity(uri, OpenWeatherDto.class);

        // WeatherStackException !!!!!!

        if (response.getStatusCode().value() != 200){
            System.out.println(response.getStatusCode());
            System.out.println(response.getStatusCode().value());
            System.out.println(response);
            return response.getBody();
        }
        else {

            return response.getBody();
        }
    }
}
