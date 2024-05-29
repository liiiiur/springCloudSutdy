package com.wangxia.core.core.common.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wangxia.core.core.common.domain.Role;
import com.wangxia.core.core.common.service.RoleService;
import com.wangxia.core.core.common.mapper.RoleMapper;
import org.springframework.stereotype.Service;

/**
* @author liur
* @description 针对表【Role】的数据库操作Service实现
* @createDate 2024-04-11 12:59:36
*/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
    implements RoleService{

}




