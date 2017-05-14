package com.geteat.service;

import com.geteat.dao.UserDao;
import com.geteat.dto.subscription.SubscribeDto;
import com.geteat.exception.UserAlreadySubscribedException;
import com.geteat.exception.UserNotExistingException;
import com.geteat.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kuba on 2017-05-12.
 */
@Service
public class UserService {

    private Map<String, User> userMap = new HashMap<>();

    @Autowired
    private UserDao userDao;

    @Transactional
    @javax.transaction.Transactional
    public User subscribeUser(SubscribeDto subscribeDto) throws UserAlreadySubscribedException {
        User user = new User(subscribeDto.getEmail(), subscribeDto.getCity(),
                subscribeDto.getState());
        userDao.persist(user);
        return user;
    }

    @Transactional
    @javax.transaction.Transactional
    public void unsubscribeUser(SubscribeDto subscribeDto) throws UserNotExistingException {
        userDao.deleteByEmail(subscribeDto.getEmail());
    }
}
