package com.wangxia.photo.controller;



import com.wangxia.core.core.common.dto.PhotoDto;
import com.wangxia.photo.domain.Photo;
import com.wangxia.photo.service.PhotoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("/photo")
@Tag(name = "照片微服务模块",description = "照片CRUD")
public class PhotoController {

    private final PhotoService photoService;

    public PhotoController(@Autowired PhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping("/{id}")
    @Operation(summary = "通过id查询照片",description = "通过id查询照片")
    public PhotoDto getPhotoById(@PathVariable("id") String id) {
        Photo photo = photoService.getById(id);
        PhotoDto photoDto = new PhotoDto();
        BeanUtils.copyProperties(photo,photoDto);
        return photoDto;
    }

    @PostMapping("/save")
    @Operation(summary = "保存",description = "保存照片")
    public Boolean savePhoto(@RequestBody PhotoDto photoDto) {
        Photo photo = new Photo();
        BeanUtils.copyProperties(photoDto,photo);
        boolean save = photoService.save(photo);
        return save;
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "通过id删除照片",description = "通过id删除照片")
    public Boolean deletePhotoById(@PathVariable("id") Integer id) {
        boolean b = photoService.removeById(id);
        return b;
    }
}
