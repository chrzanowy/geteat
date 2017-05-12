package com.geteat.service;

import com.geteat.dto.SubscribeDto;
import com.geteat.model.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kuba on 2017-05-12.
 */
@Service
public class UserService {

    private Map<String,User> userMap = new HashMap<>();

    public boolean isUserAlreadySubscribed(String email) {
        return userMap.containsKey(email);
    }

    public User subscribeUser(SubscribeDto subscribeDto) {
        return userMap.put(subscribeDto.getEmail(), new User(subscribeDto.getEmail(), subscribeDto.getCity(),
                subscribeDto.getState()));
    }

    public User unsubscribeUser(SubscribeDto subscribeDto) {
        return userMap.remove(subscribeDto.getEmail());
    }
}
