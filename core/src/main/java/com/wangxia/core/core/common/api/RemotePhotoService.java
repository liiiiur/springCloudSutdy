package com.wangxia.core.core.common.api;

import com.wangxia.core.core.common.dto.PhotoDto;
import org.springframework.beans.BeanUtils;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;


@FeignClient("photoService")
@RequestMapping("/photo")
public interface RemotePhotoService {

    @GetMapping("/{id}")
    public PhotoDto getPhotoById(@PathVariable("id") String id);

    @PostMapping("/save")
    public Boolean savePhoto(@RequestBody PhotoDto photoDto);

    @DeleteMapping("/{id}")
    public Boolean deletePhotoById(@PathVariable("id") Integer id);
}
