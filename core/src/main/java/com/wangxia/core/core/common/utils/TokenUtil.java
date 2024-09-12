package com.wangxia.core.core.common.utils;

import com.wangxia.core.core.common.utils.jwt.JWT;
import com.wangxia.core.core.common.utils.jwt.JWTUtil;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;

@Component
public class TokenUtil {

    private static final String SECRET_KEY = "wangxia";

    public String generateToken(HashMap<String, Object> payload) {
        return JWTUtil.createToken(payload,SECRET_KEY.getBytes(StandardCharsets.UTF_8));
    }

    public String generateToken(String username) {
        HashMap<String, Object> payload = new HashMap<>();
        payload.put("username", username);
        payload.put("exp", System.currentTimeMillis() + (1000 * 60 * 60 * 24));

        return JWTUtil.createToken(payload,SECRET_KEY.getBytes(StandardCharsets.UTF_8));
    }

    public boolean verifyToken(String token) {
        return JWTUtil.verify(token, SECRET_KEY.getBytes(StandardCharsets.UTF_8));
    }

    public String getUsernameFromToken(String token) {
        JWT jwt=JWTUtil.parseToken(token);
        return jwt.getPayload("username").toString();
    }
}
