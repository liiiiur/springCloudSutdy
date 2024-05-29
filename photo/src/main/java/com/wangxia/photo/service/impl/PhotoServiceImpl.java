package com.wangxia.photo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wangxia.photo.domain.Photo;
import com.wangxia.photo.dto.PictureDto;
import com.wangxia.photo.service.PhotoService;
import com.wangxia.photo.mapper.PhotoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
* @author liur
* @description 针对表【p_photo】的数据库操作Service实现
* @createDate 2024-03-22 09:23:16
*/
@Service
public class  PhotoServiceImpl extends ServiceImpl<PhotoMapper, Photo>
    implements PhotoService{

    private final MongoTemplate mongoTemplate;

    private final PhotoMapper photoMapper;

    @Autowired
    public PhotoServiceImpl(MongoTemplate mongoTemplate, PhotoMapper photoMapper) {
        this.mongoTemplate = mongoTemplate;
        this.photoMapper = photoMapper;
    }

    @Override
    public String savePicture(Photo photo, PictureDto pictureDto) {

        photoMapper.insert(photo);
        mongoTemplate.save(pictureDto,"pic");

        return "";
    }
}




