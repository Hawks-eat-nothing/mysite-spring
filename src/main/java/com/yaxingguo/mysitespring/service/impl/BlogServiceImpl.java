package com.yaxingguo.mysitespring.service.impl;

import com.yaxingguo.mysitespring.dao.BlogDao;
import com.yaxingguo.mysitespring.dto.DetailedBlog;
import com.yaxingguo.mysitespring.dto.ShowBlog;
import com.yaxingguo.mysitespring.entity.Blog;
import com.yaxingguo.mysitespring.entity.ResponseResult;
import com.yaxingguo.mysitespring.entity.Tag;
import com.yaxingguo.mysitespring.enums.AppHttpCodeEnum;
import com.yaxingguo.mysitespring.exception.SystemException;
import com.yaxingguo.mysitespring.service.BlogService;
import com.yaxingguo.mysitespring.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogDao blogDao;

    @Autowired
    private RedisCache redisCache;


    @Override
    public List<Blog> getAllBlog() {
        List<Blog> blogs = blogDao.getAllBlog();
        for (Blog blog : blogs) {
            Integer redisViews = redisCache.getCacheMapValue("blog:viewCount", blog.getId().toString());
            blog.setViews(redisViews.longValue());
        }
        return blogs;
    }

    @Override
    public Blog getBlogById(Long id) {
        Blog blog = blogDao.getBlogById(id);
        Integer redisViewCount = redisCache.getCacheMapValue("blog:viewCount", id.toString());
        blog.setViews(redisViewCount.longValue());
        return blog;
    }

    @Override
    public ResponseResult updateViewCount(Long id) {
        //更新redis中对应id的浏览量
        redisCache.incrementCacheMapValue("blog:viewCount",id.toString(),1);
        return ResponseResult.okResult();
    }

    @Override
    public void updateBatchById(List<Blog> blogs) {
        for (Blog blog : blogs) {
            blogDao.updateById(blog.getId(),blog.getViews());
        }

    }

    @Override
    public ResponseResult addBlog(Blog blog) {
        //对标题进行非空判断
        if (!StringUtils.hasText(blog.getTitle())){
            throw new SystemException(AppHttpCodeEnum.TITLE_NOT_NULL);
        }
        blog.setCreateTime(new Date());
        blog.setUpdateTime(new Date());
        blogDao.saveBlog(blog);
        return ResponseResult.okResult();

    }

    @Override
    public ResponseResult<List<Tag>> getTagsById(Long id) {
        List<Tag> tagsById = blogDao.getTagsById(id);
        return ResponseResult.okResult(tagsById);
    }
}
