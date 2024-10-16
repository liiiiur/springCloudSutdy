package com.wangxia.core.core.common.controller;

import cn.hutool.core.convert.NumberWithFormat;
import com.wangxia.core.core.common.constant.AjaxResult;
import com.wangxia.core.core.common.domain.User;
import com.wangxia.core.core.common.service.LoginHisService;
import com.wangxia.core.core.common.service.UserService;
import com.wangxia.core.core.common.utils.TokenUtil;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/common")
public class LoginController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private TokenUtil tokenUtil;

    @Autowired
    private UserService userService;

    @Autowired
    private LoginHisService loginHisService;

    private static final String TOKEN_PREFIX = "User-Token:";

    @RequestMapping(method = RequestMethod.GET,value = "/needLogin")
    public AjaxResult needLogin(HttpServletRequest request){
        String header = request.getHeader("Token");
        if (header != null&& !header.isEmpty()) {
            Object exp = tokenUtil.getValue(header, "exp");
            if(exp!=null&&((NumberWithFormat)exp).longValue()>System.currentTimeMillis()){
                String usernameToken = tokenUtil.getUsernameFromToken(header);
                String authToken = (String) redisTemplate.opsForValue().get(TOKEN_PREFIX + usernameToken);
                if(authToken!=null&&tokenUtil.verifyToken(authToken)){
                    String username = tokenUtil.getUsernameFromToken(authToken);
                    if(username != null){
                        return AjaxResult.success(true);
                    }
                }
            }
        }
        return AjaxResult.success(false);
    }

    @Operation(description = "登录账号",summary = "登录")
    @RequestMapping(method = RequestMethod.POST,value = "/login")
    public AjaxResult login(@RequestBody User user, HttpServletRequest request){
        String token = userService.login(user,request);

        HashMap<Object, Object> data = new HashMap<>();
        data.put("token", token);
        return AjaxResult.success(data);
    }

    @GetMapping("/logout")
    public AjaxResult logout(HttpServletRequest request){
        String header = request.getHeader("Token");
        if (header != null&& !header.isEmpty()) {
            String usernameToken = tokenUtil.getUsernameFromToken(header);
            redisTemplate.delete(TOKEN_PREFIX + usernameToken);
        }
        return AjaxResult.success(true);
    }
}
