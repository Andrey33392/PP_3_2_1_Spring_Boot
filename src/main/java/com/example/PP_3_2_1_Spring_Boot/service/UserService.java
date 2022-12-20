package com.example.PP_3_2_1_Spring_Boot.service;

import com.example.PP_3_2_1_Spring_Boot.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();

    Optional<User> getById(Long id);

    User saveUser(User user);

    void deleteUserById(Long id);


}
