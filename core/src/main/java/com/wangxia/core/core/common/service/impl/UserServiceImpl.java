package com.wangxia.core.core.common.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wangxia.core.core.common.domain.LoginUser;
import com.wangxia.core.core.common.service.UserService;
import com.wangxia.core.core.common.mapper.UserMapper;
import com.wangxia.core.core.common.utils.StringUtils;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

/**
 * @author liur
 * @description 针对表【User】的数据库操作Service实现
 * @createDate 2024-04-11 12:59:45
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, LoginUser>
         implements UserService, UserDetailsService, UserDetailsPasswordService {

    public boolean validateUser(LoginUser user) {
        return !StringUtils.isEmpty(user.getUsername()) && !StringUtils.isEmpty(user.getPassword());
    }

    @Override
    public void createUser(LoginUser user) {
        UserDetails userDetails = User.withUserDetails(user)
                .build();
        user.setPassword(userDetails.getPassword());
        this.save(user);
    }

    private static final String USER_CACHE_PREFIX = "user:";

    @Resource
    private UserMapper userMapper;

    @Resource
    private RedisTemplate<String,Object> redisTemplate;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        String userKey = USER_CACHE_PREFIX + username;
        LoginUser user = (LoginUser) redisTemplate.opsForValue().get(userKey);
        if (user == null) {
            QueryWrapper<LoginUser> wrapper = new QueryWrapper<>();

            wrapper.eq("username", username);

            user = userMapper.selectOne(wrapper);

            if (user == null) {
                throw new UsernameNotFoundException(username);
            }
            redisTemplate.opsForValue().set(userKey+username,user.toString());
        }
        return user;
    }

    @Override
    public UserDetails updatePassword(UserDetails user, String newPassword) {
        return null;
    }
}




