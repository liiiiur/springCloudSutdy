package com.wangxia.core.core.common.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.wangxia.core.core.common.entity.BaseEntity;
import lombok.Data;


/**
 * 
 * @TableName User
 */
@TableName(value ="User")
@Data
public class LoginUser extends BaseEntity implements Serializable {

    @TableId(type = IdType.ASSIGN_UUID)
    private Long id;

    /**
     * 
     */
    private String username;

    /**
     * 
     */
    private String password;

    /**
     * 
     */
    private String email;

    /**
     * 权限
     */
    @TableField(exist = false)
    private List<String> roles;


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}