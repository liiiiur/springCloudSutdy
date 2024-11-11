package com.wangxia.core.common.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import lombok.Data;

/**
 * 
 * @TableName UserRole
 */
@TableName(value ="UserRole")
@Data
public class Userrole implements Serializable {
    /**
     *
     */
    private String userId;

    /**
     * 
     */
    private String roleId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}