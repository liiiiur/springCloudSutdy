package com.wangxia.core.core.common.service;




import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wangxia.core.core.common.constant.AjaxResult;
import com.wangxia.core.core.common.dto.LoginUserDto;
import com.wangxia.core.core.common.mapper.RoleMapper;
import com.wangxia.core.core.common.mapper.UserMapper;
import com.wangxia.core.core.common.mapper.UserroleMapper;
import com.wangxia.core.core.common.remoteService.RemoteLoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.jackson2.SimpleGrantedAuthorityMixin;
import org.springframework.stereotype.Service;


@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RemoteLoginService remoteLoginService;

    @Autowired
    private UserroleMapper userroleMapper;

    private RoleMapper roleMapper;

    @Override
    public LoginUserDto loadUserByUsername(String username) throws UsernameNotFoundException {
        AjaxResult result = remoteLoginService.findUserByUsername(username);
        Object data = result.get("data");

        ObjectMapper mapper = new ObjectMapper();
        try {
            String userJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
            LoginUserDto user = mapper.readValue(userJson, LoginUserDto.class);
            return user;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
