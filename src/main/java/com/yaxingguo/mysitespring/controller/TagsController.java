package com.yaxingguo.mysitespring.controller;

import com.yaxingguo.mysitespring.annotation.SystemLog;
import com.yaxingguo.mysitespring.entity.ResponseResult;
import com.yaxingguo.mysitespring.entity.Tag;
import com.yaxingguo.mysitespring.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class TagsController {

    @Autowired
    private TagService tagService;

    @GetMapping("/tags")
    @ResponseBody
    @SystemLog(businessName = "获取全部标签")
    public ResponseResult<List<Tag>> getAllTags(){
        return tagService.getAllTags();
    }
}
