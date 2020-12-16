package com.example.boot.service;

import com.example.boot.entity.User;

import java.util.List;


public interface UserService {
    List<User> usersFuzzyQuery(User user, Integer current);
    void addUsers(User user);
    Integer updateUser(User user);
    Integer deleteUser(Integer id);
    User getUserByUserName(String userName);

}
