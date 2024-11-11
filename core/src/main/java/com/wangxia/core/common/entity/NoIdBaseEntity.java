package com.wangxia.core.common.entity;

import com.wangxia.core.common.utils.CreateBy;
import com.wangxia.core.common.utils.CreateTime;
import com.wangxia.core.common.utils.UpdateBy;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class NoIdBaseEntity implements Serializable {
    @CreateBy
    private String createdName;

    @CreateTime
    private Date createdTime;

    @UpdateBy
    private String modifiedName;

    @UpdateBy
    private Date modifiedTime;
}
