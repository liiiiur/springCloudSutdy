package com.wangxia.core.common.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wangxia.core.common.constant.AjaxResult;
import com.wangxia.core.common.domain.LoginHis;
import com.wangxia.core.common.domain.Role;
import com.wangxia.core.common.domain.User;
import com.wangxia.core.common.dto.LoginUserDto;
import com.wangxia.core.common.mapper.LoginHisMapper;
import com.wangxia.core.common.mapper.RoleMapper;
import com.wangxia.core.common.mapper.UserMapper;
import com.wangxia.core.common.remoteService.RemoteLoginService;
import com.wangxia.core.common.service.UserService;
import com.wangxia.core.common.utils.IpUtil;
import com.wangxia.core.common.utils.TokenUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.TimeUnit;


/**
 * @author liur
 * @description 针对表【User】的数据库操作Service实现
 * @createDate 2024-04-11 12:59:45
 */
@Service
@Primary
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
         implements UserService, UserDetailsService {
    
    private final String userRedisKey = "User-Token:";

    private final String cookieRedisKey = "Cookie-Token:";

    @Autowired
    private RemoteLoginService remoteLoginService;
    
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private LoginHisMapper loginHisMapper;
    
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private TokenUtil tokenUtil;

    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    
    @Override
    public boolean isHaveUser(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", user.getUsername());
        user = userMapper.selectOne(queryWrapper);
        return user == null;
    }

    @Override
    public String createUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        boolean save = this.save(user);
        if(save){
            return user.getId();
        }
        return null;
    }

    @Override
    public String login(User loginUser, HttpServletRequest request) {
        LoginUserDto user = loadUserByUsername(loginUser.getUsername());
        if(user == null){
            throw new RuntimeException("用户不存在");
        }else {
            if(bCryptPasswordEncoder.matches(loginUser.getPassword(), user.getPassword())){
                String ip = IpUtil.getIp(request);

                HashMap<String, Object> tokenMap = new HashMap<>();
                tokenMap.put("ip", ip);
                tokenMap.put("user", user);
                tokenMap.put("username", user.getUsername());

                String token = tokenUtil.generateToken(tokenMap);

                // 保存用户信息到redis
                redisTemplate.opsForValue().set(userRedisKey + user.getUsername(), token,60, TimeUnit.MINUTES);

                //保存登录记录

                LoginHis loginHis = new LoginHis();
                loginHis.setUsername(user.getUsername());
                loginHis.setIp(ip);
                loginHis.setLoginTime(LocalDateTime.now());
                loginHisMapper.insert(loginHis);

                return tokenUtil.generateToken(user.getUsername(),ip);
            }else {
                throw new RuntimeException("密码错误");
            }
        }
    }

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

    @Override
    public LoginUserDto getUserByUsername(String username) {
        User user = userMapper.selectByName(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        List<Role> roleList=roleMapper.selectByUserId(user.getId());



        if(user.getIsAdmin()==1){
            Role role = new Role();
            role.setName("ROLE_ADMIN");
            role.setId("60e2b35d2455bf06a84600db672f20e4");
            roleList.add(role);
        }

        LoginUserDto loginUserDto = new LoginUserDto();
        loginUserDto.setUsername(user.getUsername());
        loginUserDto.setPassword(user.getPassword());
        loginUserDto.setRoles(roleList);


        return loginUserDto;
    }
}




