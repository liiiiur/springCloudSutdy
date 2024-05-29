package com.wangxia.core.core.common.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import com.wangxia.core.core.common.entity.BaseEntity;
import lombok.Data;

/**
 * 
 * @TableName Role
 */
@TableName(value ="Role")
@Data
public class Role extends BaseEntity implements Serializable {

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String description;


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}