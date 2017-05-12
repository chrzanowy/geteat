package com.geteat.controller;

import com.geteat.dto.SubscribeDto;
import com.geteat.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Jake on 23.04.2017.
 */
@RestController
public class SubscriptionController {

    @Autowired
    SubscriptionService subscriptionService;

    @RequestMapping(value = "/subscribe", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void subscribe(@RequestBody SubscribeDto subscribeDto){
        subscriptionService.subscribe(subscribeDto);
    }


}
