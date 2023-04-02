package com.yaxingguo.mysitespring.service;

import com.yaxingguo.mysitespring.entity.ResponseResult;
import com.yaxingguo.mysitespring.entity.Tag;

import java.util.List;

public interface TagService {
    ResponseResult<List<Tag>> getAllTags();

    void bind(String title, String tagIds);
}
