package com.example.boot.controller;

import com.example.boot.constant.ResultCode;
import com.example.boot.entity.User;
import com.example.boot.result.Result;
import com.example.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/addUser")
    public Result getUser(){
        User user=new User();
        user.setUserName("cs2");
        user.setPassword("123456");
        userService.addUsers(user);
        List<String> list=new ArrayList<>();
        list.add("cs");
        Integer.valueOf(list.get(0));
        return new Result(ResultCode.SUCCESS);
    }


}
