package com.wangxia.core.common.utils;

import jakarta.servlet.http.HttpServletRequest;

public class IpUtil {
    public static String getIp(HttpServletRequest request) {
        String ip = null;

        // 获取X-Forwarded-For头信息，多个代理服务器会通过逗号分隔
        String ipAddresses = request.getHeader("X-Forwarded-For");
        if (ipAddresses != null && !ipAddresses.isEmpty() && !"unknown".equalsIgnoreCase(ipAddresses)) {
            // X-Forwarded-For可能包含多个IP地址，取第一个非unknown的IP作为客户端IP
            ip = ipAddresses.split(",")[0].trim();
        }

        // 如果通过Nginx等代理没有获取到真实IP，则尝试从其他头中获取
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP"); // Weblogic代理
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }

        // 如果上述头信息都没有获取到，直接从request对象中获取
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        // 如果IP是IPv6的回环地址，转换为IPv4的回环地址
        if ("0:0:0:0:0:0:0:1".equals(ip)) {
            ip = "127.0.0.1";
        }

        return ip;
    }
}
