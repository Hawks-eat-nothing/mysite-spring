package com.yaxingguo.mysitespring.dto;

import com.yaxingguo.mysitespring.entity.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailedBlog {
    private Long id;
    private String title;
    private String content;
    private String coverImg;
    private String flag;
    private Integer views;
    private boolean commentAbled;
    private Date updateTime;
    private List<Tag> tags = new ArrayList<>();
}
