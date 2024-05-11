package com.wangxia.photo.service;

import com.wangxia.photo.domain.Photo;
import com.wangxia.photo.dto.PictureDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.imageio.ImageIO;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PhotoServiceTest {

    @Autowired
    private PhotoService photoService;

    @Test
    void savePicture() {
        Photo photo = new Photo();
        PictureDto pictureDto = new PictureDto();
        photo.setId("1");


        photoService.savePicture(photo,pictureDto);
    }
}