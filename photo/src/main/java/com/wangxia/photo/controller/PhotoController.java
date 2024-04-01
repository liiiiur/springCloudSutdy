package com.wangxia.photo.controller;



import com.wangxia.core.core.common.dto.PhotoDto;
import com.wangxia.photo.domain.Photo;
import com.wangxia.photo.service.PhotoService;
import com.wangxia.photo.service.impl.PhotoServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "照片微服务模块",description = "照片CRUD")
@RequestMapping("/photo")
public class PhotoController {

    private static final Logger log = LoggerFactory.getLogger(PhotoController.class);
    @Autowired
    private PhotoServiceImpl photoService;

    @GetMapping("/get")
    @Operation(summary = "通过id查询照片",description = "通过id查询照片")
    public PhotoDto getPhotoById(@RequestParam("id") String id) {

        try {
            Photo photo = photoService.getById(id);
            PhotoDto photoDto = new PhotoDto();
            BeanUtils.copyProperties(photo,photoDto);
            return photoDto;
        }catch (Exception e){
            log.error(e.getMessage(),e);
        }
        return null;
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
