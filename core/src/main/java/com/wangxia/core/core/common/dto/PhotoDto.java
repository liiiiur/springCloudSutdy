package com.wangxia.core.core.common.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PhotoDto {

    /**
     *
     */
    private String name;

    /**
     *
     */
    private String url;

    /**
     *
     */
    private Date createdTime;

    /**
     *
     */
    private String createdName;

    /**
     *
     */
    private String modifiedName;

    /**
     *
     */
    private Date modifiedTime;

    /**
     *
     */
    private Integer age;

    /**
     *
     */
    private String place;
}
