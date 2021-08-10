package com.xm.controller;

import com.xm.entity.Camera;
import com.xm.service.CameraService;
import com.xm.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class CamreaController {

    @Autowired
    Result result;

    @Autowired
    CameraService cameraService;

    @CrossOrigin
    @PostMapping("/addCamera")
    public Result addCamera(@RequestBody Camera camera){
        boolean b = cameraService.addCamera(camera);
        return result;
    }



}
