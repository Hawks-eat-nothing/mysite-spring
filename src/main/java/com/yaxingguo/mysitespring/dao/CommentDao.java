package com.yaxingguo.mysitespring.dao;

import com.yaxingguo.mysitespring.dto.CommentDto;
import com.yaxingguo.mysitespring.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CommentDao {
    List<Comment> listCommentByBlogId(Long blogId);
    List<CommentDto> listChildComments(Long rootId);

    int addComment(Comment comment);
}
