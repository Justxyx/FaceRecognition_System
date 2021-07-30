package com.xm.controller;

import com.xm.entity.User;
import com.xm.service.UserService;
import com.xm.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping("/getUserList/{groupId}")
    public Result getUserList(@PathVariable("groupId")String groupId){
        List<User> userList = userService.getUserList(Integer.parseInt(groupId));
        result.setCode(200);
        result.setData(userList);
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



}
