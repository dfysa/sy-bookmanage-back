package com.book.backend.testutils;

import com.book.backend.common.JwtProperties;
import com.book.backend.pojo.Users;
import com.book.backend.utils.JwtKit;
import io.jsonwebtoken.Claims;

/**
 * @author dfysa
 * @data 2024/6/6 上午9:13
 * @description
 */
public class JwtTest {
    public static void main(String[] args) {
        JwtProperties jwtProperties = new JwtProperties();
        jwtProperties.setSecret("mall-jwt-test"); // 使用你的密钥
        jwtProperties.setExpiration(36000000); // 设置 token 过期时间（毫秒）
        jwtProperties.setTokenHeader("Authorization");
        jwtProperties.setTokenHead("Bearer");

        JwtKit jwtKit = new JwtKit(jwtProperties);

        Users user = new Users();
        user.setUsername("琼楼玉宇");
        user.setUserId(1L);

        String token = jwtKit.generateToken(user);
        System.out.println("生成的 Token: " + token);

        Claims claims = jwtKit.parseJwtToken(token);
        System.out.println("解析的 Claims: " + claims);
    }
}
