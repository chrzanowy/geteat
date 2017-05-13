package com.geteat.service;

import com.geteat.dao.UserDao;
import com.geteat.dto.rso.News;
import com.geteat.dto.rso.Rso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Long latestId = 0L; //TODO implement getting it from base
        List<News> latestNewsForStates = rsoService.getLatestNewsForStates(allStates, latestId);
        Optional<News> max = latestNewsForStates
                .stream()
                .max((o1, o2) -> Long.compare(Long.valueOf(o1.getId()), Long.valueOf(o2.getId())));
        latestNewsForStates.getClass();
        //TODO send rso to mail service
    }
}
