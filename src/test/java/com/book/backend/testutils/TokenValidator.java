package com.book.backend.testutils;

import com.book.backend.common.JwtProperties;
import com.book.backend.utils.JwtKit;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.SignatureException;

import javax.annotation.Resource;

/**
 * @author dfysa
 * @data 2024/6/6 上午8:27
 * @description
 */
public class TokenValidator {

    private JwtKit jwtKit;

    public TokenValidator(JwtKit jwtKit) {
        this.jwtKit = jwtKit;
    }

    public void validateToken(String token) {
        try {
            Claims claims = jwtKit.parseJwtToken(token);
            System.out.println("Token 有效");
            System.out.println("声明信息: " + claims);
        } catch (ExpiredJwtException e) {
            System.out.println("Token 已过期");
        } catch (SignatureException e) {
            System.out.println("无效的 Token 签名");
        } catch (JwtException e) {
            System.out.println("无效的 Token");
        } catch (Exception e) {
            System.out.println("验证 Token 时发生错误");
        }
    }

    public static void main(String[] args) {
        JwtProperties jwtProperties = new JwtProperties();
        jwtProperties.setSecret("123456"); // 设置你的密钥
        jwtProperties.setExpiration(3600000); // 设置 token 过期时间（毫秒）

        JwtKit jwtKit = new JwtKit(jwtProperties);
        TokenValidator tokenValidator = new TokenValidator(jwtKit);

        // 生成一个 token
        String token = jwtKit.generateToken("testuser"); // 替换为实际用户信息
        System.out.println("生成的 Token: " + token);

        // 验证生成的 token
        tokenValidator.validateToken(token);
    }
}