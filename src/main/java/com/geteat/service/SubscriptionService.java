package com.geteat.service;

import com.geteat.dto.subscription.SubscribeDto;
import com.geteat.exception.UserAlreadySubscribedException;
import com.geteat.exception.UserNotExistingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Jake on 23.04.2017.
 */
@Service
public class SubscriptionService {

    @Autowired
    private UserService userService;

    @Autowired
    private MailSenderService mailSenderService;

    @Autowired
    private RsoService rsoService;

    public void subscribe(SubscribeDto subscribeDto) throws UserAlreadySubscribedException {
       userService.subscribeUser(subscribeDto);
        mailSenderService.sendMail(subscribeDto.getEmail(), "Zostales zasubskrybowany do serwisu!");
    }


    public void unsubscribe(SubscribeDto subscribeDto) throws UserNotExistingException {
        userService.unsubscribeUser(subscribeDto);
        mailSenderService.sendMail(subscribeDto.getEmail(), "Zostales usuniety z subskrybcji!");
    }
}
