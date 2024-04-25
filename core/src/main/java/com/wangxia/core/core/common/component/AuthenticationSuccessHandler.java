//package com.wangxia.core.core.common.component;
//
//import com.wangxia.core.core.common.dto.TokenUser;
//import com.wangxia.core.core.common.utils.StringUtils;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Collection;
//
//@Component
//public class AuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
//
//    private static final String HTTP_TOKEN_PREFIX = "WX_TOKEN_PREFIX";
//
//    private static final String HTTP_USER_PREFIX = "WX_USER_PREFIX";
//
//    private final RedisTemplate redisTemplate;
//
//    public AuthenticationSuccessHandler(@Qualifier("redisTemplate") RedisTemplate redisTemplate) {
//        this.redisTemplate = redisTemplate;
//    }
//
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
//        System.out.println("登录成功回调");
//        ArrayList<String> permissionList = new ArrayList<>();
//        Collection<? extends GrantedAuthority> authorities = ((UserDetails) authentication.getPrincipal()).getAuthorities();
//        for (GrantedAuthority authority : authorities) {
//            permissionList.add(authority.getAuthority());
//        }
//        String username = ((UserDetails) authentication.getPrincipal()).getUsername();
//        TokenUser tokenUser = new TokenUser(username, permissionList, false);
//
//        String oldToken = (String) redisTemplate.opsForValue().get(HTTP_USER_PREFIX + username);
//        if(StringUtils.isNotNull(oldToken)){
//            redisTemplate.delete(HTTP_TOKEN_PREFIX + username);
//        }
//    }
//}
