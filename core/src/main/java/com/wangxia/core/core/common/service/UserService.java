package com.wangxia.core.core.common.service;

import com.wangxia.core.core.common.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wangxia.core.core.common.dto.LoginUserDto;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;


/**
* @author liur
* @description 针对表【User】的数据库操作Service
* @createDate 2024-04-11 12:59:45
*/
public interface UserService extends IService<User> {

    boolean isHaveUser(User user);

    String createUser(User user);

    String login(User user, HttpServletRequest request);

    LoginUserDto getUserByUsername(String username);
}
