package com.yaxingguo.mysitespring.controller;

import com.yaxingguo.mysitespring.entity.ResponseResult;
import com.yaxingguo.mysitespring.entity.User;
import com.yaxingguo.mysitespring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user/login")
    public ResponseResult login(@RequestBody User user){
        return userService.login(user);
    }
    @RequestMapping("/user/logout")
    public ResponseResult logout(){
        return userService.logout();
    }
}
