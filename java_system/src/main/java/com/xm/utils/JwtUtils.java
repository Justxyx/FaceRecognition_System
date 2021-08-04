package com.xm.utils;

import io.jsonwebtoken.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.UUID;

public class JwtUtils {
    static long time = 1000*60*60*24;   // 设置token过期时间
    static String signature = "admin";  // 盐值

    public static String generateToken(String username,int role,int groupId){
        JwtBuilder builder = Jwts.builder();
        String token = builder
                // 设置Header
                .setHeaderParam("type","Jwt")
                .setHeaderParam("alg","Hs256")
                // 设置载荷Payload
                .claim("username",username)
                .claim("role",role)
                .claim("groupId",groupId)
                // 设置主题
                .setSubject("jwt")
                //设置过载时间
                .setExpiration(new Date(System.currentTimeMillis()+time))
                //设置id
                .setId(UUID.randomUUID().toString())
                //signature
                .signWith(SignatureAlgorithm.HS256,signature)
                .compact();
        return token;
    }


    public static int parserToken(String token,String parms){
        JwtParser jwtParser = Jwts.parser();

        Jws<Claims> claimsJes = null;
        try {
            claimsJes = jwtParser.setSigningKey(signature).parseClaimsJws(token);
        } catch (Exception e) {
            return -1;
        }

        Claims body = claimsJes.getBody();
        return (int) body.get(parms);
    }

    public static int tokenRoles(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        String token = request.getHeader("token");
        int roles = JwtUtils.parserToken(token,"role");
        return roles;           // -1 ,0 ,1 ,2 ,  -1 为没有token
    }

    public static int tokenGroupId(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        String token = request.getHeader("token");
        int groupId = JwtUtils.parserToken(token,"groupId");
        return groupId;
    }
}
