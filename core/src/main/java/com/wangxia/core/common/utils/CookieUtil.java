package com.wangxia.core.common.utils;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CookieUtil {

    public Cookie addBrowserCookie(String browserId) {
        Cookie cookie = new Cookie("BROWSER_ID", browserId);
        cookie.setHttpOnly(true);
        cookie.setMaxAge(60 * 60 * 24 * 30); // 设置Cookie有效期为30天
        cookie.setPath("/");
        return cookie;
    }

    public String getBrowserIdFromCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("BROWSER_ID".equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
}
