package com.yaxingguo.mysitespring.service.impl;

import com.yaxingguo.mysitespring.dao.UserDao;
import com.yaxingguo.mysitespring.entity.LoginUser;
import com.yaxingguo.mysitespring.entity.ResponseResult;
import com.yaxingguo.mysitespring.entity.User;
import com.yaxingguo.mysitespring.enums.AppHttpCodeEnum;
import com.yaxingguo.mysitespring.exception.SystemException;
import com.yaxingguo.mysitespring.service.UserService;
import com.yaxingguo.mysitespring.utils.BeanCopyUtils;
import com.yaxingguo.mysitespring.utils.JwtUtils;
import com.yaxingguo.mysitespring.utils.RedisCache;
import com.yaxingguo.mysitespring.vo.LoginVo;
import com.yaxingguo.mysitespring.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public ResponseResult login(User user) {

        //AuthenticationManager 进行用户认证
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        //如果认证没通过，给出对应的提示
        if (Objects.isNull(authenticate)) {
            throw new RuntimeException("登录失败");
        }
        //如果认证通过了，使用userid生成一个jwt,jwt存入responseResult返回
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userid = loginUser.getUser().getId().toString();
        String jwt = JwtUtils.createJWT(userid);
        //把完整的用户信息存入redis,userid作为key
        redisCache.setCacheObject("login:" + userid, loginUser);
        //把token响应给前端
        //把User转换成UserInfoVo
        UserInfoVo userInfoVo = BeanCopyUtils.copyBean(loginUser.getUser(), UserInfoVo.class);
        LoginVo loginVo = new LoginVo(jwt, userInfoVo);
        return ResponseResult.okResult(loginVo);
    }

    @Override
    public ResponseResult logout() {
        //获取SecurityContextHolder中的用户id
        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();

        LoginUser loginUser = (LoginUser) authentication.getPrincipal();

        Long userid = loginUser.getUser().getId();

        //删除redis中的值
        redisCache.deleteObject("login:" + userid);
        return ResponseResult.okResult();
    }

    @Override
    public ResponseResult register(User user) {
        //对数据进行非空判断
        if (!StringUtils.hasText(user.getUserName())) {
            throw new SystemException(AppHttpCodeEnum.USERNAME_NOT_NULL);
        }
        if (!StringUtils.hasText(user.getPassword())) {
            throw new SystemException(AppHttpCodeEnum.PASSWORD_NOT_NULL);
        }
        if (!StringUtils.hasText(user.getEmail())) {
            throw new SystemException(AppHttpCodeEnum.EMAIL_NOT_NULL);
        }
        if (!StringUtils.hasText(user.getNickName())) {
            throw new SystemException(AppHttpCodeEnum.NICKNAME_NOT_NULL);
        }
        //对数据进行是否存在的判断
        if (userNameExist(user.getUserName())) {
            throw new SystemException(AppHttpCodeEnum.USERNAME_EXIST);
        }
        if (nicknameExist(user.getNickName())) {
            throw new SystemException(AppHttpCodeEnum.NICKNAME_EXIST);
        }
        //对密码进行加密
        String encodePassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodePassword);
        //存入数据库
        userDao.saveUser(user);
        return ResponseResult.okResult();
        //TODO 后续研究一下用户id用什么方式生成以及注册时的验证机制
    }

    private boolean nicknameExist(String nickname) {
        Integer cnt = userDao.checkNicknameExist(nickname);
        if (cnt>0||cnt!=null){
            return false;
        }
        return true;
    }

    private boolean userNameExist(String userName) {
        Integer cnt = userDao.checkUsernameExist(userName);
        if (cnt>0||cnt!=null){
            return false;
        }
        return true;
    }

}
