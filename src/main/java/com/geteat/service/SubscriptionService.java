package com.geteat.service;

import com.geteat.dto.SubscribeDto;
import com.geteat.exception.UserAlreadySubscribedException;
import com.geteat.exception.UserNotExistingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Jake on 23.04.2017.
 */
@Service
public class SubscriptionService {

    @Autowired
    private UserService userService;

    @Autowired
    private RsoService rsoService;

    public void subscribe(SubscribeDto subscribeDto) throws UserAlreadySubscribedException {
        if (!userService.isUserAlreadySubscribed(subscribeDto.getEmail())) {
            userService.subscribeUser(subscribeDto);
        } else {
            throw new UserAlreadySubscribedException(subscribeDto.getEmail());
        }
    }


    public void unsubscribe(SubscribeDto subscribeDto) throws UserNotExistingException {
        if (!userService.isUserAlreadySubscribed(subscribeDto.getEmail())) {
            userService.unsubscribeUser(subscribeDto);
        } else {
            throw new UserNotExistingException(subscribeDto.getEmail());
        }
    }
}
