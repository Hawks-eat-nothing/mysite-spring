package com.yaxingguo.mysitespring.entity;

import com.yaxingguo.mysitespring.dto.CommentDto;
import com.yaxingguo.mysitespring.dto.DetailedBlog;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private Long id;
    private String nickname;
    private String email;
    private String content;
    private Date createTime;

    private Long blogId;
    private Long rootId;
    private String toCommentNickname;
    private Long toCommentId;
    private Integer delFlag;

    private List<CommentDto> children = new ArrayList<>();



}
