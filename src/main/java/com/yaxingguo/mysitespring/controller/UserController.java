package com.yaxingguo.mysitespring.controller;

import com.yaxingguo.mysitespring.annotation.SystemLog;
import com.yaxingguo.mysitespring.entity.ResponseResult;
import com.yaxingguo.mysitespring.entity.User;
import com.yaxingguo.mysitespring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @SystemLog(businessName = "用户登录")
    public ResponseResult login(@RequestBody User user){
        System.out.println(user);
        return userService.login(user);
    }
    @PostMapping("/logout")
    @SystemLog(businessName = "用户登出")
    public ResponseResult logout(){
        return userService.logout();
    }

    @PostMapping("/register")
    @SystemLog(businessName = "用户注册")
    public ResponseResult register(@RequestBody User user){
        return userService.register(user);
    }
}
