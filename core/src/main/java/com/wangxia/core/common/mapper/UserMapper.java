package com.wangxia.core.common.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wangxia.core.common.domain.User;

/**
* @author liur
* @description 针对表【User】的数据库操作Mapper
* @createDate 2024-04-11 12:59:45
* @Entity com.wangxia.core.core.common.domain.User
*/
public interface UserMapper extends BaseMapper<User> {

    User selectByName(String username);
}




