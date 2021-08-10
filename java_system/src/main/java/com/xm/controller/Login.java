package com.xm.controller;


import com.xm.entity.Group;
import com.xm.entity.User;
import com.xm.entity.UserMin;
import com.xm.service.LoginService;
import com.xm.utils.JwtUtils;
import com.xm.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
public class Login {

    @Autowired
    Result result;
    @Autowired
    LoginService loginService;

    @CrossOrigin
    @PostMapping("/login")
    public Result login(@RequestBody User user){
        User loginUser = loginService.findUserByPassword(user.getUserId(),user.getGroupId());
        if( loginUser == null){
            result.setCode(400);
            result.setMsg("该账户不存在");
        }else if(loginUser.getUserPassword().equals(loginUser.getUserPassword())){
            result.setCode(200);
            result.setMsg("密码正确，登录成功");
            String token = JwtUtils.generateToken(loginUser.getUserName(), loginUser.getRole(),loginUser.getGroupId());
            loginUser.setToken(token);
            result.setData(loginUser);
        }else {
            result.setCode(400);
            result.setMsg("密码错误，请重新输入密码");
        }
        return result;
    }


    @CrossOrigin
    @GetMapping("/findAllGroups")
    public Result groups(){
        List<Group> allGroups = loginService.findAllGroups();
        result.setData(allGroups);
        System.out.println(result);
        return result;
    }

}


