package com.wangxia.core.core.common.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wangxia.core.core.common.domain.Permission;
import com.wangxia.core.core.common.service.PermissionService;
import com.wangxia.core.core.common.mapper.PermissionMapper;
import org.springframework.stereotype.Service;

/**
* @author liur
* @description 针对表【Permission】的数据库操作Service实现
* @createDate 2024-04-11 12:57:07
*/
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission>
    implements PermissionService{

}




