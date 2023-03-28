package com.yaxingguo.mysitespring.dao;

import com.yaxingguo.mysitespring.dto.DetailedBlog;
import com.yaxingguo.mysitespring.dto.ShowBlog;
import com.yaxingguo.mysitespring.entity.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BlogDao {
    List<ShowBlog> getAllBlog();
    Blog getBlogById(Long id);

    List<Blog> getBlogIdAndViews();

    void updateById(Long id,Long views);
}
