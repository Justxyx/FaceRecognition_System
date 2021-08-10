package com.xm.service;

import com.xm.entity.Camera;
import com.xm.mapper.CameraMapper;
import com.xm.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CameraService {
    @Autowired
    CameraMapper cameraMapper;

    public boolean addCamera(Camera camera){

        int groupId = JwtUtils.tokenGroupId();
        camera.setGroupId(groupId);
        String src = "rtsp://"+ camera.getCameraName() + ":" + camera.getCameraPwd() + "@" + camera.getCameraIp()+ ":" + camera.getCameraPort()  + "/ch1/main/av_stream";
        camera.setCameraSrc(src);
        System.out.println(src);
        try {
           boolean b = cameraMapper.addCamera(camera);
        } catch (Exception e) {
            System.out.println("添加用户失败");
            return  false;
        }
        return true;
    }
}
