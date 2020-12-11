package com.example.boot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.boot.entity.User;
import com.example.boot.mapper.UserMapper;
import com.example.boot.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl  extends ServiceImpl<UserMapper, User> implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public List<User> usersFuzzyQuery(User user, Integer current) {
        return userMapper.usersFuzzyQuery(user,current);
    }

    @Override
    public void addUsers(User user) {
        userMapper.insert(user);
    }

    @Override
    public Integer updateUser(User user) {
        return userMapper.updateById(user);
    }

    @Override
    public Integer deleteUser(Integer id) {
        return userMapper.deleteById(id);
    }
}
