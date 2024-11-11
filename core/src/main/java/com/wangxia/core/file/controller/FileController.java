package com.wangxia.core.file.controller;

import com.wangxia.core.common.constant.AjaxResult;
import com.wangxia.core.file.service.FileService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/file/")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public AjaxResult upload(@RequestParam("file") MultipartFile file){
            String s = fileService.uploadFile(file);
            return AjaxResult.success(s);
    }

    // 文件下载接口
    @GetMapping("/download/{fileName}")
    public void downloadFile(@PathVariable String fileName, HttpServletResponse response) {
            // 调用 FileService 中的 downloadFile 方法
            fileService.downloadFile(fileName, response);

    }
}
