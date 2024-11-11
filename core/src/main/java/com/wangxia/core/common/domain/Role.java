package com.wangxia.core.common.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import com.wangxia.core.common.entity.BaseEntity;
import lombok.Data;

/**
 * 角色表
 * @TableName Role 角色表
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