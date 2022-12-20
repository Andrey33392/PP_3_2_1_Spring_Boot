package com.example.PP_3_2_1_Spring_Boot.service;

import com.example.PP_3_2_1_Spring_Boot.dao.UserDao;
import com.example.PP_3_2_1_Spring_Boot.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {
    private final UserDao userDao;

    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> findAll() {
        return (List<User>) userDao.findAll();
    }

    @Override
    public Optional<User> getById(Long id) {
        return userDao.findById(id);
    }

    @Override
    public User saveUser(User user) {
        return userDao.save(user);
    }

    @Override
    public void deleteUserById(Long id) {
        userDao.deleteById(id);
    }
}
