package com.wangxia.core.common.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wangxia.core.common.domain.Role;
import com.wangxia.core.common.service.RoleService;
import com.wangxia.core.common.mapper.RoleMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
* @author liur
* @description 针对表【Role】的数据库操作Service实现
* @createDate 2024-04-11 12:59:36
*/
@Service
@Primary
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
    implements RoleService{

    @Override
    public Boolean saveRole(Role role) {
        if(role==null){
            return false;
        }
        if(!role.getName().startsWith("ROLE_")){
            role.setName("ROLE_"+role.getName());
        }
        return this.save(role);
    }
}




