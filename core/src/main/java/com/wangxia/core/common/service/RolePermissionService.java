package com.wangxia.core.common.service;

import com.wangxia.core.common.domain.Permission;
import com.wangxia.core.common.domain.Role;
import com.wangxia.core.common.domain.RolePermission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author liur
* @description 针对表【RolePermission】的数据库操作Service
* @createDate 2024-09-09 17:16:26
*/
public interface RolePermissionService extends IService<RolePermission> {

    void addRolePermission(Role role, List<Permission> permissionList);
}
