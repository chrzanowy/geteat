package com.geteat.service;

import com.geteat.dao.UserDao;
import com.geteat.dto.rso.Rso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Kuba on 2017-05-13.
 */
@Service
public class IntegrationService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private WeatherService weatherService;
    @Autowired
    private RsoService rsoService;

    public void sendWeatherForecast() {
        List allCities = userDao.findAllCities();
        weatherService.fetchWeatherForCities(allCities);
    }

    public void fetchLatestRso() {
        List allStates = userDao.findAllStates();
        Rso latestNewsForStates = rsoService.getLatestNewsForStates(allStates);
        //TODO send rso to mail service
    }
}
