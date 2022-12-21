package com.example.PP_3_2_1_Spring_Boot.service;

import com.example.PP_3_2_1_Spring_Boot.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User getById(Long id);

    void saveUser(User user);

    void deleteUserById(Long id);

    void updateUser(User user);


}
