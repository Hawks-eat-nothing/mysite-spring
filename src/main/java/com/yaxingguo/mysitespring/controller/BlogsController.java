package com.yaxingguo.mysitespring.controller;

import com.google.gson.Gson;
import com.yaxingguo.mysitespring.dto.DetailedBlog;
import com.yaxingguo.mysitespring.dto.ShowBlog;
import com.yaxingguo.mysitespring.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> getAllBlogs(){
        List<ShowBlog> allBlog = blogService.getAllBlog();
        Gson gson = new Gson();
        return ResponseEntity.ok().body(gson.toJson(allBlog));
    }

    @GetMapping("/detail/{id}")
    @ResponseBody
    public ResponseEntity<String> getBlogById(@PathVariable Long id){
        DetailedBlog detailedBlog = blogService.getBlogById(id);
        Gson gson = new Gson();
        return ResponseEntity.ok().body(gson.toJson(detailedBlog));
    }
}
