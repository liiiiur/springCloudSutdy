package com.wangxia.core.core.common.config;

import com.wangxia.core.core.common.component.JwtAuthenticationFilter;
import com.wangxia.core.core.common.service.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class WebSecurityConfig {

    private final CustomUserDetailService userService;

    private final SecurityProperties securityProperties;

    @Autowired
    public WebSecurityConfig(CustomUserDetailService userService, SecurityProperties securityProperties) {
        this.userService = userService;
        this.securityProperties = securityProperties;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return (userService);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests((authorizeHttpRequests)->{
                    authorizeHttpRequests
                            .requestMatchers(securityProperties.getPermitAll().toArray(new String[0])).permitAll()
                            .requestMatchers("/**").hasRole("ADMIN") // 拥有管理员角色的用户可以访问所有接口
                            .anyRequest()//所有请求
                            .authenticated(); //自动授权
                })
                .csrf(AbstractHttpConfigurer::disable)
                //.httpBasic(Customizer.withDefaults()) //基本授权方式
                .formLogin((formLogin)->{
                    formLogin.loginPage(securityProperties.getLoginPage());
                })
                .addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)

  ;
        return http.build();
    }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter();
    }
}
