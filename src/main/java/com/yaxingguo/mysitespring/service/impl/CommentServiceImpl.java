package com.yaxingguo.mysitespring.service.impl;

import com.yaxingguo.mysitespring.dao.CommentDao;
import com.yaxingguo.mysitespring.dto.CommentDto;
import com.yaxingguo.mysitespring.entity.Comment;
import com.yaxingguo.mysitespring.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("commentService")
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentDao commentDao;
    @Override
    public List<Comment> commentList(Long blogId) {
        //查询对应文章的根评论
        List<Comment> comments = commentDao.listCommentByBlogId(blogId);
        for (Comment comment : comments) {
            Long rootId = comment.getId();
            if (commentDao.listChildComments(rootId)!=null){
                comment.setChildren(commentDao.listChildComments(rootId));
            }
        }
        //分页查询

        return comments;
    }

    @Override
    public int addComment(Comment comment) {
        return commentDao.addComment(comment);
    }
}
