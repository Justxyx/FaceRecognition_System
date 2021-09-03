package com.xm.controller;


import com.xm.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.annotation.Retention;

@Controller
@ResponseBody
public class TestController {
    @Autowired
    Result result;

    @CrossOrigin
    @GetMapping("/test")
    public Result test(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("请求成功");
        result.setCode(200);
        return result;
    }
}
