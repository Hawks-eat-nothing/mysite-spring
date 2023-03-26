package com.yaxingguo.mysitespring.controller;

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
    public ResponseResult login(@RequestBody User user){
        System.out.println(user);
        return userService.login(user);
    }
    @GetMapping("/logout")
    public ResponseResult logout(){
        return userService.logout();
    }
}
