package com.geteat.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Jake on 23.04.2017.
 */
public class SubscribeDto {
    @JsonProperty
    private final String email;
    @JsonProperty
    private final String city;
    @JsonProperty
    private final String state;


    public SubscribeDto(String email, String city, String state) {
        this.email = email;
        this.city = city;
        this.state = state;
    }
}
