package com.wangxia.photo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wangxia.photo.domain.Photo;
import com.wangxia.photo.service.PhotoService;
import com.wangxia.photo.mapper.PhotoMapper;
import org.springframework.stereotype.Service;

/**
* @author liur
* @description 针对表【p_photo】的数据库操作Service实现
* @createDate 2024-03-22 09:23:16
*/
@Service
public class  PhotoServiceImpl extends ServiceImpl<PhotoMapper, Photo>
    implements PhotoService{

}




