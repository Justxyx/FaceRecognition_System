package com.xm.service;

import com.xm.entity.Camera;
import com.xm.mapper.CameraMapper;
import com.xm.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CameraService {
    @Autowired
    CameraMapper cameraMapper;

    public boolean addCamera(Camera camera){
        int groupId = JwtUtils.tokenGroupId();
        camera.setGroupId(groupId);
        String src = "rtsp://"+ camera.getCameraName() + ":" + camera.getCameraPwd() + "@" + camera.getCameraIp()+ ":" + camera.getCameraPort()  + "/ch1/main/av_stream";
        camera.setCameraSrc(src);
        try {
           boolean b = cameraMapper.addCamera(camera);
        } catch (Exception e) {
            System.out.println("添加用户失败");
            return  false;
        }
        return true;
    }

    public List<Camera> cameraList(){
        int groupId = JwtUtils.tokenGroupId();
        List<Camera> cameraList = null;
        try {
            cameraList = cameraMapper.cameraList(groupId);
        } catch (Exception e) {
            // 后期加日志系统
            System.out.println("查询失败");
        }
        return cameraList;
    }

    public boolean deleteCameraById(String id){
        int gId = JwtUtils.tokenGroupId();
        long cid = Integer.parseInt(id);
        boolean b;
        try {
            cameraMapper.deleteCameraById(gId, cid);
            b = true;
        } catch (Exception e) {
            System.out.println("删除失败");
            b = false;
        }
        return b;
    }
}
