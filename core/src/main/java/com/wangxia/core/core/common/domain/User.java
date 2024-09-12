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
public class User extends BaseEntity implements Serializable {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 是否启用
     */
    private int isEnable;

    /**
     * 是否管理员
     */
    private int isAdmin;


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}