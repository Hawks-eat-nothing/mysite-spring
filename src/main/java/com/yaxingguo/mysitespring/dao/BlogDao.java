package com.yaxingguo.mysitespring.dao;

import com.yaxingguo.mysitespring.dto.DetailedBlog;
import com.yaxingguo.mysitespring.dto.ShowBlog;
import com.yaxingguo.mysitespring.entity.Blog;
import com.yaxingguo.mysitespring.entity.Tag;
import javafx.scene.control.Tab;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BlogDao {
    List<Blog> getAllBlog();
    Blog getBlogById(Long id);

    List<Blog> getBlogIdAndViews();

    void updateById(Long id,Long views);

    void saveBlog(Blog blog);

    List<Tag> getTagsById(Long id);

    Long getIdByTitle(String title);
}
