package com.goodhealth.provider.eurake.controller;

import com.goodhealth.provider.eurake.pojo.User;
import com.goodhealth.provider.eurake.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getUser")
    public List<User> getUser(){
        return userService.getUser();
    }

}
