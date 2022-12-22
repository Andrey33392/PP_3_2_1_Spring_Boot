package com.example.PP_3_2_1_Spring_Boot.service;

import com.example.PP_3_2_1_Spring_Boot.dao.UserDao;
import com.example.PP_3_2_1_Spring_Boot.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class UserServiceImp implements UserService {
    private final UserDao userDao;

    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User getById(Long id) {
        return userDao.getById(id);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDao.saveUser(user);

    }

    @Override
    @Transactional
    public void deleteUserById(Long id) {
        userDao.deleteUserById(id);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userDao.updateUser(user);
    }
}
