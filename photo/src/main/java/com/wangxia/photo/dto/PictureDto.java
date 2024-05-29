package com.wangxia.photo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PictureDto {
    private String id;

    private String name;

    private String path;

    private String data;

    private String size;
}
