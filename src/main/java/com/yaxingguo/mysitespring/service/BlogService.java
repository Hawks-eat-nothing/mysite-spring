package com.yaxingguo.mysitespring.service;

import com.yaxingguo.mysitespring.dto.DetailedBlog;
import com.yaxingguo.mysitespring.dto.ShowBlog;
import com.yaxingguo.mysitespring.entity.Blog;
import com.yaxingguo.mysitespring.entity.ResponseResult;

import java.util.List;

public interface BlogService {
    List<ShowBlog> getAllBlog();
    Blog getBlogById(Long id);

    ResponseResult updateViewCount(Long id);

    void updateBatchById(List<Blog> blogs);
}
