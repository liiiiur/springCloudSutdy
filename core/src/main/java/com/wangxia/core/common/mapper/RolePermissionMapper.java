package com.wangxia.core.common.mapper;

import com.wangxia.core.common.domain.RolePermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author liur
* @description 针对表【RolePermission】的数据库操作Mapper
* @createDate 2024-09-09 17:16:26
* @Entity com.wangxia.core.core.common.domain.RolePermission
*/
public interface RolePermissionMapper extends BaseMapper<RolePermission> {

    List<RolePermission> selectByRoleId(String roleId);

    void removeByRoleId(String id);

    void insertAll(List<RolePermission> addList);
}




