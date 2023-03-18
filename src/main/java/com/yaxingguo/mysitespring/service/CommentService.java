package com.yaxingguo.mysitespring.service;

import com.yaxingguo.mysitespring.dto.CommentDto;
import com.yaxingguo.mysitespring.entity.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> commentList(Long blogId);
    int addComment(Comment comment);
}
