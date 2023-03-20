package com.yaxingguo.mysitespring.service.impl;

import com.yaxingguo.mysitespring.dao.UserDao;
import com.yaxingguo.mysitespring.entity.LoginUser;
import com.yaxingguo.mysitespring.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Objects;

public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //根据用户名查询用户信息
        User user = userDao.getUserByUserName(userName);
        if (Objects.isNull(user)){
            throw  new RuntimeException("用户名或密码错误");
        }
        //TODO 查询对应的权限信息

        //把数据封装成userDetails返回
        return new LoginUser(user);
    }
}
