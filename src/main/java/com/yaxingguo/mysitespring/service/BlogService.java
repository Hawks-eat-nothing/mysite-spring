package com.yaxingguo.mysitespring.service;

import com.yaxingguo.mysitespring.dto.DetailedBlog;
import com.yaxingguo.mysitespring.dto.ShowBlog;

import java.util.List;

public interface BlogService {
    List<ShowBlog> getAllBlog();
    DetailedBlog getBlogById(Long id);
}
