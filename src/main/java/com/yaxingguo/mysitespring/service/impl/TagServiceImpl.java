package com.yaxingguo.mysitespring.service.impl;

import com.yaxingguo.mysitespring.dao.BlogDao;
import com.yaxingguo.mysitespring.dao.TagDao;
import com.yaxingguo.mysitespring.entity.ResponseResult;
import com.yaxingguo.mysitespring.entity.Tag;
import com.yaxingguo.mysitespring.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagDao tagDao;

    @Autowired
    private BlogDao blogDao;

    @Override
    public ResponseResult<List<Tag>> getAllTags() {
        List<Tag> allTags = tagDao.getAllTags();
        return ResponseResult.okResult(allTags);
    }

    @Override
    public void bind(String title, String tagIds) {
        String[] tags = tagIds.split(",");
        Long id = blogDao.getIdByTitle(title);
        for (String tid : tags) {
            tagDao.bind(Long.parseLong(tid),id);
        }
    }
}
