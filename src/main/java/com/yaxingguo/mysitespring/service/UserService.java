package com.yaxingguo.mysitespring.service;

import com.yaxingguo.mysitespring.entity.ResponseResult;
import com.yaxingguo.mysitespring.entity.User;

public interface UserService {

    ResponseResult login(User user);


    ResponseResult logout();

}
