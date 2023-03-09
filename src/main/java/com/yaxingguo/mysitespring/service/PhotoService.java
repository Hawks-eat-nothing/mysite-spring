package com.yaxingguo.mysitespring.service;

import com.yaxingguo.mysitespring.dto.PhotoDto;
import com.yaxingguo.mysitespring.entity.Photo;

import java.util.List;

public interface PhotoService {
    List<PhotoDto> getAllPhotos();

    Photo getPhotoById(Long id);

    List<PhotoDto> getFirstPagePhoto();

    int addPhoto(Photo photo);
}
