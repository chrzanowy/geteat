package com.geteat.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jake on 14.05.2017.
 */
@Service
public class MailSenderService {

    private static final String MAIL_API_KEY = "$bE6Ft}3*2Eu<s>H]dh,ue/vB%d5:d@!NFoo{:QE";
    private static final String MAIL_BOX_URL = "http://serwer1399643.home.pl/sendMail/";

    private RestTemplate restTemplate = new RestTemplate();

    public void sendMail(String email, String content) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> parameterMap= new LinkedMultiValueMap();
        parameterMap.put("apiKlucz", Collections.singletonList(MAIL_API_KEY));
        parameterMap.put("odbiorca", Collections.singletonList(email));
        parameterMap.put("tresc", Collections.singletonList(content));
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(parameterMap, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(MAIL_BOX_URL, request, String.class);
    }

}