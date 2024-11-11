package com.wangxia.core.file.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wangxia.core.file.domain.File;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;

public interface FileService extends IService<File> {
    String uploadFile(MultipartFile file);

    void downloadFile(String fileName, HttpServletResponse response);
}
