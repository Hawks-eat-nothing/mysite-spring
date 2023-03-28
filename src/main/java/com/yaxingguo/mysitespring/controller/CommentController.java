package com.yaxingguo.mysitespring.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yaxingguo.mysitespring.annotation.SystemLog;
import com.yaxingguo.mysitespring.dto.CommentDto;
import com.yaxingguo.mysitespring.entity.Comment;
import com.yaxingguo.mysitespring.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/commentList/{blogId}")
    @SystemLog(businessName = "展示评论")
    public ResponseEntity<String> commentList(@PathVariable Long blogId){
        List<Comment> comments = commentService.commentList(blogId);
        Gson gson = new Gson();
        return ResponseEntity.ok().body(gson.toJson(comments));
    }
    @PostMapping("/add")
    @SystemLog(businessName = "提交评论")
    public ResponseEntity<String> addComment(@RequestBody String json){
        Gson gson = new GsonBuilder().create();
        System.out.println(json);
        Date now=new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String date = sdf.format(now);
        Comment comment = gson.fromJson(json, Comment.class);
        comment.setCreateTime(now);
        System.out.println(comment.getEmail());
        System.out.println(comment.getNickname());

        commentService.addComment(comment);
        return ResponseEntity.ok("success");
    }
}
