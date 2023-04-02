package com.yaxingguo.mysitespring.dao;

import com.yaxingguo.mysitespring.entity.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TagDao {
    List<Tag> getAllTags();

    void bind(Long tagId,Long blogId);
}
