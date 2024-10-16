package com.wangxia.photo.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import com.wangxia.core.core.common.entity.BaseEntity;
import lombok.Data;

/**
 * 
 * @TableName p_photo
 */
@TableName(value ="p_photo")
@Data
public class Photo extends BaseEntity implements Serializable {
    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String url;


    private Integer age;

    /**
     * 
     */
    private String place;

    /**
     * 删除标识
     */
    private Integer deleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}