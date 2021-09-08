package com.xm.controller;

import com.xm.entity.Infos;
import com.xm.service.InfosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
public class InfosController {

    @Autowired
    InfosService infosService;

    @CrossOrigin
    @PostMapping("/add")
    public boolean add(@RequestBody Infos infos){
        return infosService.addInfos(infos);
    }

    @CrossOrigin
    @PostMapping("/delete")
    public boolean delete(@RequestBody String userId){
        System.out.println("-------------------------");
        System.out.println(userId);
        return infosService.deleteInfos(userId);
    }
}
