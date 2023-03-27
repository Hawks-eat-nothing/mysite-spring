package com.yaxingguo.mysitespring.dao;

import com.yaxingguo.mysitespring.entity.User;
import com.yaxingguo.mysitespring.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (User)表数据库访问层
 *
 * @author makejava
 * @since 2023-03-18 20:54:49
 */
@Repository
@Mapper
public interface UserDao {

    User getUserByUserName(String userName);


    User getUserByNickname(String nickname);

    void saveUser(User user);

    int checkUsernameExist(String userName);
    int checkNicknameExist(String userName);
}

