package com.xm.controller;

import com.xm.entity.Camera;
import com.xm.entity.PageBean;
import com.xm.service.CameraService;
import com.xm.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        result.setData(null);
        if(b){
            result.setCode(200);
            result.setMsg("添加成功");
        }else {
            result.setCode(400);
            result.setMsg("添加失败");
        }
        return result;
    }


    @CrossOrigin
    @GetMapping("/cameraList/{pageNo}/{pageSize}")
    public Result cameraList(@PathVariable("pageNo") String pageNo,@PathVariable("pageSize") String pageSize){
        PageBean pageBean = cameraService.cameraList(pageNo, pageSize);
        result.setData(pageBean);
        if(pageBean.getLists() == null){
            result.setCode(400);
            result.setMsg("查询失败");
        }else{
            result.setCode(200);
            result.setMsg("查询成功");
        }
        return result;
    }

    @CrossOrigin
    @GetMapping("/deleteCameraById/{id}")
    public Result deleteCameraById(@PathVariable("id") String id){
        boolean b = cameraService.deleteCameraById(id);
        result.setData(null);
        if (b){
            result.setCode(200);
            result.setMsg("删除成功");
        }else {
            result.setCode(400);
            result.setMsg("删除失败");
        }
        return result;
    }
}
