package com.wangxia.core.file.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.wangxia.core.common.entity.BaseEntity;
import lombok.Data;

import java.io.Serializable;

@TableName(value = "file")
@Data
public class File extends BaseEntity implements Serializable {

    private String tableId;

    private String filePath;
}
