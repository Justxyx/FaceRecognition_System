package com.xm.controller;

import com.xm.entity.PageBean;
import com.xm.entity.User;
import com.xm.service.Base64Service;
import com.xm.service.UserService;
import com.xm.utils.JwtUtils;
import com.xm.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.util.List;

@Controller
@ResponseBody
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    Result result;





    @CrossOrigin
    @RequestMapping("/getUserList/{pageNo}/{pageSize}")
    public Result getUserList(@PathVariable("pageNo") String pageNo,@PathVariable("pageSize") String pageSize){


        PageBean  pageBean= userService.getUserList(pageNo,pageSize);
        result.setCode(200);
        result.setData(pageBean);
        return result;
    }

    @CrossOrigin
    @PostMapping("/addUser")
    public Result addUser(@RequestBody User user){
        boolean b = userService.addUser(user);
        if (b){
            result.setCode(200);
            return result;
        }else {
            result.setCode(400);
            result.setMsg("添加用户失败");
            return result;
        }
    }

    @CrossOrigin
    @GetMapping("/deleteUserById/{userId}")
    public Result deleteUserById(@PathVariable("userId") String userId){
        boolean b = userService.deleteUserById(userId);
        if(b){
            result.setCode(200);
            result.setMsg("删除成功");
            result.setData(null);
        }else {
            result.setCode(400);
        }
        return result;
    }



}
