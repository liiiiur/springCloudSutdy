package com.wangxia.core.core.common.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import com.wangxia.core.core.common.entity.BaseEntity;
import lombok.Data;

/**
 * 
 * @TableName RolePermission
 */
@TableName(value ="RolePermission")
@Data
public class RolePermission implements Serializable {

    /**
     * 
     */
    private String permissionId;

    /**
     * 
     */
    private String roleId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}