package com.geteat.service;

import com.geteat.dto.rso.News;
import com.geteat.dto.rso.Newses;
import com.geteat.dto.rso.Rso;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Kuba on 2017-05-13.
 */
@Service
public class RsoService {

    private final RestTemplate restTemplate = new RestTemplate();

    public List<News> getLatestNewsForStates(List allStates, Long latestId) {
        //TODO support pagination
        Rso rso = new Rso(restTemplate
                .getForObject("https://komunikaty.tvp.pl/komunikatyxml/wszystkie/wszystkie/1?_format=xml",
                        Newses.class));
        return Arrays.stream(rso.getNewses().getNews())
                .filter(news -> Long.valueOf(news.getId()) > latestId)
                .filter(news -> allStates.contains(news.getProvinces().getProvince().getSlug()))
                .collect(Collectors.toList());
    }


}
