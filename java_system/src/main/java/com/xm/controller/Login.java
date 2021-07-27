package com.xm.controller;


import com.xm.entity.UserMin;
import com.xm.utils.JwtUtils;
import com.xm.utils.Result;
import com.xm.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
public class Login {


    @Autowired
    Result result;

    @CrossOrigin
    @PostMapping("/login")
    public Result login(@RequestBody UserMin userMin){
        userMin.setRole(2);
        String token = JwtUtils.generateToken(userMin.getUsername(), userMin.getRole());
        userMin.setToken(token);
        result.setData(userMin);
        result.setMsg("成功");
        result.setCode(200);

        return result;
    }

    @CrossOrigin
    @GetMapping("/checkToken")
    public int tokenDemo(){
        int roles = TokenUtils.tokenRoles();
        return roles;
    }
}


