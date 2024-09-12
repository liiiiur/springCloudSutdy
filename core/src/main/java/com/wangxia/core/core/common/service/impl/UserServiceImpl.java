package com.wangxia.core.core.common.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wangxia.core.core.common.domain.Role;
import com.wangxia.core.core.common.domain.User;
import com.wangxia.core.core.common.domain.Userrole;
import com.wangxia.core.core.common.dto.LoginUserDto;
import com.wangxia.core.core.common.mapper.RoleMapper;
import com.wangxia.core.core.common.mapper.UserroleMapper;
import com.wangxia.core.core.common.service.UserService;
import com.wangxia.core.core.common.mapper.UserMapper;
import com.wangxia.core.core.common.utils.CookieUtil;
import com.wangxia.core.core.common.utils.TokenUtil;
import com.wangxia.core.core.common.utils.jwt.JWTUtil;
import jakarta.servlet.http.Cookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author liur
 * @description 针对表【User】的数据库操作Service实现
 * @createDate 2024-04-11 12:59:45
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
         implements UserService{
    
    private final String userRedisKey = "User-Token:";

    private final String cookieRedisKey = "Cookie-Token:";
    
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserroleMapper userroleMapper;

    @Autowired
    private RoleMapper roleMapper;
    
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private TokenUtil tokenUtil;

    @Autowired
    private CookieUtil cookieUtil;

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
    public String login(User loginUser) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", loginUser.getUsername());
        User user = userMapper.selectOne(queryWrapper);
        if(user == null){
            throw new RuntimeException("用户不存在");
        }else {
            if(bCryptPasswordEncoder.matches(loginUser.getPassword(), user.getPassword())){
                String token = tokenUtil.generateToken(user.getUsername());

                // 保存用户信息到redis
                redisTemplate.opsForValue().set(userRedisKey + user.getUsername(), token,60, TimeUnit.MINUTES);
                String o = (String) redisTemplate.opsForValue().get(userRedisKey + user.getUsername());
                HashMap<String, Object> cookieMap = new HashMap<>();
                cookieMap.put("username", user.getUsername());
                String cookieToken = tokenUtil.generateToken(cookieMap);
                return cookieToken;
            }else {
                throw new RuntimeException("密码错误");
            }
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




