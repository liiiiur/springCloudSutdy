package com.wangxia.core.core.common.api;

import com.wangxia.core.core.common.dto.PhotoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("photoService")
public interface RemotePhotoService {

    @GetMapping("/photo/get")
    PhotoDto getPhotoById(@RequestParam("id") String id);

    @PostMapping("/save")
    Boolean savePhoto(@RequestBody PhotoDto photoDto);

    @DeleteMapping("/{id}")
    Boolean deletePhotoById(@PathVariable("id") Integer id);
}
