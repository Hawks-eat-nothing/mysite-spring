package com.yaxingguo.mysitespring.dao;

import com.yaxingguo.mysitespring.dto.PhotoDto;
import com.yaxingguo.mysitespring.entity.Photo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface PhotoDao {
    Photo getImageById(Long id);

    List<PhotoDto> getAll();

    List<PhotoDto> getFirstPagePhoto();

    int addPhoto(Photo photo);
}
