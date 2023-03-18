package com.yaxingguo.mysitespring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
    private Long id;
    private String nickname;
    private String content;
    private Date createTime;
    private Long rootId;
    private String toCommentNickname;
}
