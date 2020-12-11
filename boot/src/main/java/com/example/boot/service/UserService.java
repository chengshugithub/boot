package com.example.boot.service;

import com.example.boot.entity.User;

import java.util.List;


public interface UserService {
    List<User> usersFuzzyQuery(User puser, Integer current);
    void addUsers(User puser);
    Integer updateUser(User puser);
    Integer deleteUser(Integer id);
}
