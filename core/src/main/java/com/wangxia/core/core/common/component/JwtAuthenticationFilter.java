package com.wangxia.core.core.common.component;


import cn.hutool.core.convert.NumberWithFormat;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wangxia.core.core.common.dto.LoginUserDto;
import com.wangxia.core.core.common.utils.TokenUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;

@Component
@ConditionalOnProperty(name = "isEnableSecurity",havingValue = "true",matchIfMissing = false)
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private TokenUtil tokenUtil;

    @Autowired
    private RedisTemplate redisTemplate;

    private static final String TOKEN_PREFIX = "User-Token:";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String header = request.getHeader("Token");
        String username = null;
        String authToken = null;

        if (header != null) {
            NumberWithFormat time = (NumberWithFormat) tokenUtil.getValue(header, "exp");
            if(time!=null&&time.longValue()>System.currentTimeMillis()){
                String usernameToken = tokenUtil.getUsernameFromToken(header);
                authToken = (String) redisTemplate.opsForValue().get(TOKEN_PREFIX + usernameToken);
                if(authToken!=null&&tokenUtil.verifyToken(authToken)){
                    username = tokenUtil.getUsernameFromToken(authToken);
                    redisTemplate.opsForValue().set(TOKEN_PREFIX + usernameToken,authToken,60, TimeUnit.MINUTES);
                }
            }
        }

        if(username != null&& SecurityContextHolder.getContext().getAuthentication()==null){
            if (tokenUtil.verifyToken(authToken)) {
                String string = tokenUtil.getValue(authToken, "user").toString();
                ObjectMapper mapper = new ObjectMapper();
                LoginUserDto userDetails = mapper.readValue(string, LoginUserDto.class);
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        userDetails, header, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        filterChain.doFilter(request, response);
    }
}
