package com.xm.controller;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.xm.entity.Menus;
import com.xm.service.MenusService;
import com.xm.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
public class MenusController {

    @Autowired
    MenusService menusService;

    @Autowired
    Result result;

    @CrossOrigin
    @GetMapping("/menus")
    public Result allMenus(){
        List<Menus> allMenus = menusService.findAllMenus();
        result.setData(allMenus);
        result.setCode(200);
        result.setMsg("请求成功");
        return result;
    }


    @CrossOrigin
    @GetMapping("/menusAlone")
    public Result allMenusAlone(){
        List<Menus> menusAlone = menusService.findMenusAlone();
        result.setData(menusAlone);
        result.setCode(200);
        result.setMsg("请求成功");
        return result;
    }

}
