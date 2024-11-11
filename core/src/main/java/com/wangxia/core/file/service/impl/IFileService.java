package com.wangxia.core.file.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wangxia.core.file.mapper.FileMapper;
import com.wangxia.core.file.service.FileService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class IFileService extends ServiceImpl<FileMapper, com.wangxia.core.file.domain.File> implements FileService {
    // 定义文件存储路径（可以在 application.yml 或 application.properties 中配置）
    @Value("${file.upload-dir}")
    private String uploadDir;

    @Autowired
    private FileMapper mapper;

    // 上传文件方法
    public String uploadFile(MultipartFile file) {
        if (file.isEmpty()) {
            return "文件为空，无法上传！";
        }

        // 获取文件名并生成存储路径
        String fileName = file.getOriginalFilename();
        Path filePath = Paths.get(uploadDir, fileName);
        try {
            // 确保存储目录存在
            Files.createDirectories(filePath.getParent());
            // 保存文件到服务器指定目录
            Files.write(filePath, file.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return "文件上传成功！文件路径：" + filePath;
    }

    // 下载文件方法
    public void downloadFile(String fileName, HttpServletResponse response)  {
        File file = new File(uploadDir, fileName);

        if (!file.exists()) {
            try {
                throw new IOException("文件未找到：" + fileName);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        // 设置响应头以触发浏览器下载文件
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

        try (FileInputStream fis = new FileInputStream(file);
             OutputStream os = response.getOutputStream()) {

            byte[] buffer = new byte[1024];
            int bytesRead;

            // 通过缓冲区写入输出流
            while ((bytesRead = fis.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
