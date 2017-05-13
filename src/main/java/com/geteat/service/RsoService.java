package com.geteat.service;

import com.geteat.dto.rso.Newses;
import com.geteat.dto.rso.Rso;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by Kuba on 2017-05-13.
 */
@Service
public class RsoService {

    private final RestTemplate restTemplate = new RestTemplate();

    public Rso getLatestNewsForStates(List allStates) {
        //TODO support pagination
        return new Rso(restTemplate
                .getForObject("https://komunikaty.tvp.pl/komunikatyxml/wszystkie/wszystkie/1?_format=xml",
                        Newses.class));
    }


}
