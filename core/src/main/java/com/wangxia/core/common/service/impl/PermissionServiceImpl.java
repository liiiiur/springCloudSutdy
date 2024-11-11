package com.wangxia.core.common.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wangxia.core.common.domain.Permission;
import com.wangxia.core.common.domain.Role;
import com.wangxia.core.common.domain.RolePermission;
import com.wangxia.core.common.mapper.RoleMapper;
import com.wangxia.core.common.mapper.RolePermissionMapper;
import com.wangxia.core.common.service.PermissionService;
import com.wangxia.core.common.mapper.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
* @author liur
* @description 针对表【Permission】的数据库操作Service实现
* @createDate 2024-04-11 12:57:07
*/
@Service
@Primary
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission>
    implements PermissionService{

}




