package com.yaxingguo.mysitespring.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.google.gson.Gson;
import com.yaxingguo.mysitespring.dao.PhotoDao;
import com.yaxingguo.mysitespring.dto.PhotoDto;
import com.yaxingguo.mysitespring.entity.Photo;
import com.yaxingguo.mysitespring.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/photos")
public class PhotosController {
    @Autowired
    private PhotoService photoService;

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/detail/{id}")
    @ResponseBody
    public ResponseEntity<String> getPhotoById(@PathVariable Long id) throws JsonProcessingException {
        Photo photo = photoService.getPhotoById(id);
        Gson gson = new Gson();
        String json = gson.toJson(photo);
        return ResponseEntity.ok().body(json);
    }

    @GetMapping("/")
    @ResponseBody
    public ResponseEntity<String> getAllPhotos(@RequestParam(defaultValue="1",value="pageNum") Integer pageNum) throws JsonProcessingException {
        PageHelper.startPage(pageNum,20);
        List<PhotoDto> res = photoService.getAllPhotos();
        Gson gson = new Gson();
        return ResponseEntity.ok().body(gson.toJson(res));

    }
    @PostMapping("/upload")
    public ResponseEntity<String> uploadPhotos(@RequestBody String json){
        Gson gson = new Gson();
        Photo photo = gson.fromJson(json, Photo.class);
        try {
            photoService.addPhoto(photo);
            return ResponseEntity.ok("success");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error");
        }

    }
}
