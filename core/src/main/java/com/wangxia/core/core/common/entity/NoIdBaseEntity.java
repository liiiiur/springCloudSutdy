package com.wangxia.core.core.common.entity;

import com.wangxia.core.core.common.utils.CreateBy;
import com.wangxia.core.core.common.utils.CreateTime;
import com.wangxia.core.core.common.utils.UpdateBy;
import lombok.Data;

import java.util.Date;

@Data
public class NoIdBaseEntity {
    @CreateBy
    private String createdName;

    @CreateTime
    private Date createdTime;

    @UpdateBy
    private String modifiedName;

    @UpdateBy
    private Date modifiedTime;
}
