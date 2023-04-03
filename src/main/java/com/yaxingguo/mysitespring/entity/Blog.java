package com.yaxingguo.mysitespring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
    private Long id;
    private String title;
    private String content;
    private String coverImg;
    private String flag;
    private Long views;
    private boolean commentAbled;
    private boolean published;
    private Date createTime;
    private Date updateTime;
    private String description;
    private String tagIds;
    private boolean deleted;
    private List<Tag> tags = new ArrayList<>();


    public Blog(Long id, long viewCount) {
        this.id=id;
        this.views = viewCount;
    }
}
