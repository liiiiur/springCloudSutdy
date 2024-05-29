package com.wangxia.core.core.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.wangxia.core.core.common.utils.CreateBy;
import com.wangxia.core.core.common.utils.CreateTime;
import com.wangxia.core.core.common.utils.UpdateBy;

import java.io.Serializable;
import java.util.Date;

public class BaseEntity implements Serializable {

    @CreateBy
    private String createdName;

    @CreateTime
    private Date createdTime;

    @UpdateBy
    private String modifiedName;

    @UpdateBy
    private Date modifiedTime;

}
