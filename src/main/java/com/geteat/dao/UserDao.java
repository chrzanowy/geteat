package com.geteat.dao;

import com.geteat.exception.UserAlreadySubscribedException;
import com.geteat.exception.UserNotExistingException;
import com.geteat.model.User;

import java.util.List;
import java.util.Optional;

/**
 * Created by Lovababu on 4/26/2015.
 */
public interface UserDao {

    void persist(User user) throws UserAlreadySubscribedException;

    void deleteByEmail(String email) throws UserNotExistingException;

    List findAllByState(String state);

    List findAllStates();

    List findAllCities();

    List findAllByCity(String city);

    Optional<User> findByEmail(String email);
}
