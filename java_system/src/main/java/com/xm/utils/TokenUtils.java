package com.xm.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class TokenUtils {
    public static int tokenRoles(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        String token = request.getHeader("token");
        int roles = JwtUtils.parserToken(token);
        return roles;           // -1 ,0 ,1 ,2 ,  -1 为没有token
    }
}
