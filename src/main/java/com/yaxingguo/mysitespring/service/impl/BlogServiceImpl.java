package com.yaxingguo.mysitespring.service.impl;

import com.yaxingguo.mysitespring.dao.BlogDao;
import com.yaxingguo.mysitespring.dto.DetailedBlog;
import com.yaxingguo.mysitespring.dto.ShowBlog;
import com.yaxingguo.mysitespring.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogDao blogDao;


    @Override
    public List<ShowBlog> getAllBlog() {
        return blogDao.getAllBlog();
    }

    @Override
    public DetailedBlog getBlogById(Long id) {
        return blogDao.getBlogById(id);
    }
}
