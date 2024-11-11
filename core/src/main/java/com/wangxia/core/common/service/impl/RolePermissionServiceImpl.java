package com.wangxia.core.common.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wangxia.core.common.domain.Permission;
import com.wangxia.core.common.domain.Role;
import com.wangxia.core.common.domain.RolePermission;
import com.wangxia.core.common.service.RolePermissionService;
import com.wangxia.core.common.mapper.RolePermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* @author liur
* @description 针对表【RolePermission】的数据库操作Service实现
* @createDate 2024-09-09 17:16:26
*/
@Service
@Primary
public class RolePermissionServiceImpl extends ServiceImpl<RolePermissionMapper, RolePermission>
    implements RolePermissionService{

    private final RolePermissionMapper mapper;

    @Autowired
    public RolePermissionServiceImpl(RolePermissionMapper mapper) {
        this.mapper = mapper;
    }

    @Transactional
    @Override
    public void addRolePermission(Role role, List<Permission> permissionList) {

        List<RolePermission> addList = permissionList.stream()
                .map(x -> {
                    RolePermission rolePermission = new RolePermission();
                    rolePermission.setRoleId(role.getId());
                    rolePermission.setPermissionId(x.getId());
                    return rolePermission;
                })
                .toList();

        mapper.removeByRoleId(role.getId());
        mapper.insertAll(addList);
    }
}




