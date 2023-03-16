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
public class ShowBlog {
    private Long id;
    private String title;
    private String coverImg;

    private Integer views;
    private Date updateTime;
    private String description;
}
