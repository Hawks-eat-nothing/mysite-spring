package com.yaxingguo.mysitespring.runner;

import com.yaxingguo.mysitespring.dao.BlogDao;
import com.yaxingguo.mysitespring.entity.Blog;
import com.yaxingguo.mysitespring.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ViewCountRunner implements CommandLineRunner {

    @Autowired
    private BlogDao blogDao;

    @Autowired
    private RedisCache redisCache;

    @Override
    public void run(String... args) throws Exception {
        //查询博客信息
        List<Blog> blogs= blogDao.getBlogIdAndViews();
        Map<String, Integer> viewsMap = new HashMap<>();
        for (Blog blog : blogs) {
            viewsMap.put(blog.getId().toString(),blog.getViews().intValue());
        }
        ///存储到redis中
        redisCache.setCacheMap("blog:viewCount",viewsMap);

    }
}
