package com.wangxia.core.core.common.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.Data;

/**
 * 登录历史
 * @TableName login_his
 */
@TableName(value ="login_his")
@Data
public class LoginHis implements Serializable {
    /**
     * 
     */
    @TableId
    private String id;

    /**
     * 用户名
     */
    private String username;

    /**
     * ip地址
     */
    private String ip;

    /**
     * 登录时间
     */
    private LocalDateTime loginTime;

    /**
     * 退出时间
     */
    private LocalDateTime exitTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}