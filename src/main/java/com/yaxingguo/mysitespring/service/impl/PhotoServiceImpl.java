package com.yaxingguo.mysitespring.service.impl;

import com.yaxingguo.mysitespring.dao.PhotoDao;
import com.yaxingguo.mysitespring.dto.PhotoDto;
import com.yaxingguo.mysitespring.entity.Photo;
import com.yaxingguo.mysitespring.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoServiceImpl implements PhotoService{

    @Autowired
    PhotoDao photoDao;

    @Override
    public List<PhotoDto> getAllPhotos() {
        List<PhotoDto> photoAll = photoDao.getAll();
        return photoAll;
    }

    @Override
    public Photo getPhotoById(Long id) {
        Photo photo = photoDao.getImageById(id);
        return photo;
    }

    @Override
    public List<PhotoDto> getFirstPagePhoto() {
        List<PhotoDto> firstPagePhoto = photoDao.getFirstPagePhoto();
        return firstPagePhoto;
    }

    @Override
    public int addPhoto(Photo photo) {
        return photoDao.addPhoto(photo);
    }


}
