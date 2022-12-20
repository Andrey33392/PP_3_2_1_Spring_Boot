package com.example.PP_3_2_1_Spring_Boot.dao;

import com.example.PP_3_2_1_Spring_Boot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository <User, Long> {
}
