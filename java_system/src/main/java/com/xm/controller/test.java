package com.xm.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class test {


    @RequestMapping("/test/{id}")
    public Integer test(@PathVariable Integer id){
        System.out.println(id);
        return id;
    }
}
