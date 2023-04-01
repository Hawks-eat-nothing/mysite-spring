package com.yaxingguo.mysitespring.controller;

import com.google.gson.Gson;
import com.yaxingguo.mysitespring.annotation.SystemLog;
import com.yaxingguo.mysitespring.dto.DetailedBlog;
import com.yaxingguo.mysitespring.dto.ShowBlog;
import com.yaxingguo.mysitespring.entity.Blog;
import com.yaxingguo.mysitespring.entity.ResponseResult;
import com.yaxingguo.mysitespring.entity.Tag;
import com.yaxingguo.mysitespring.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/blogs")
public class BlogsController {
    @Autowired
    BlogService blogService;

    @GetMapping("/")
    @ResponseBody
    @SystemLog(businessName = "博客列表")
    public ResponseEntity<String> getAllBlogs(){
        List<Blog> allBlog = blogService.getAllBlog();
        Gson gson = new Gson();
        return ResponseEntity.ok().body(gson.toJson(allBlog));
    }

    @GetMapping("/detail/{id}")
    @ResponseBody
    @SystemLog(businessName = "博客详情")
    public ResponseEntity<String> getBlogById(@PathVariable Long id){
        Blog blog = blogService.getBlogById(id);
        Gson gson = new Gson();
        return ResponseEntity.ok().body(gson.toJson(blog));
    }
//    @ResponseBody
    @PutMapping("/updateViewCount/{id}")
    public ResponseResult updateViewCount(@PathVariable Long id){
        return blogService.updateViewCount(id);
    }

    @PostMapping("/add")
    @SystemLog(businessName = "添加博客")
    public ResponseResult addBlog(@RequestBody Blog blog){
        return blogService.addBlog(blog);
    }
    @GetMapping("/tags/{id}")
    @ResponseBody
    @SystemLog(businessName = "获取标签")
    public ResponseResult<List<Tag>> getTagsById(@PathVariable Long id){
        return blogService.getTagsById(id);
    }
}
