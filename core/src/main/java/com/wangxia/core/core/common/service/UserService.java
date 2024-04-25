package com.wangxia.core.core.common.service;

import com.wangxia.core.core.common.domain.LoginUser;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.security.core.userdetails.UserDetails;

/**
* @author liur
* @description 针对表【User】的数据库操作Service
* @createDate 2024-04-11 12:59:45
*/
public interface UserService extends IService<LoginUser> {


    UserDetails loadUserByUsername(String username);

    boolean validateUser(LoginUser user);

    void createUser(LoginUser user);
}
