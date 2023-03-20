package com.yaxingguo.mysitespring.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MenuDao {
    List<String> getPermsByUserId(Long id);
}
