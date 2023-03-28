package com.yaxingguo.mysitespring.job;

import com.yaxingguo.mysitespring.entity.Blog;
import com.yaxingguo.mysitespring.service.BlogService;
import com.yaxingguo.mysitespring.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class UpdateViewCountJob {

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private BlogService blogService;

    @Scheduled(cron = "0/20 * * * * ?")
    public void updateViewCount(){
        //获取redis中的浏览量
        Map<String, Integer> map = redisCache.getCacheMap("blog:viewCount");
        List<Blog> blogs = map.entrySet().stream()
                .map(entry -> new Blog(Long.valueOf(entry.getKey()), entry.getValue().longValue()))
                .collect(Collectors.toList());

        //更新到数据库中
        blogService.updateBatchById(blogs);
    }
}
