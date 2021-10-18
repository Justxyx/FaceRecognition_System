package com.xm.controller;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.xm.entity.CameraInfo;
import com.xm.entity.PageBean;
import com.xm.service.CameraInfoService;
import com.xm.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.log4j.Logger;


import java.util.List;

@Controller
@ResponseBody
public class CameraInfoController {



    @Autowired
    Result result;

    @Autowired
    CameraInfoService cameraInfoService;


    @CrossOrigin
    @GetMapping("/getAllCameraInfo/{pageNo}/{pageSize}")
    public Result getAll(@PathVariable("pageNo") String pageNo, @PathVariable("pageSize") String pageSize){
        PageBean infos = cameraInfoService.find(pageNo,pageSize);
        result.setCode(200);
        result.setMsg("查询成功");
        result.setData(infos);
        return result;
    }
}
