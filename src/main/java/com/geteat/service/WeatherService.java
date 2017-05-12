package com.geteat.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jake on 22.04.2017.
 */
@Service
public class WeatherService {


    private static final String WEATHER_API_KEY = "ae07914d3182f59a5e597279c1d4a85c";

    private final RestTemplate restTemplate = new RestTemplate();

    public String getLocalizationForLatitudeAndLongitude(String latitude, String longitude) {
        Map<String, String> parameterMap = new HashMap<>();
        parameterMap.put("latitude", latitude);
        parameterMap.put("longitude", longitude);
        parameterMap.put("key", WEATHER_API_KEY);
        String forObject = restTemplate
                .getForObject("http://api.openweathermap.org/data/2.5/weather?lat={latitude}&lon={longitude}&appid={key}&units=metric",
                        String.class,
                        parameterMap);
        forObject.getClass();
        return forObject;
    }

}