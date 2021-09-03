package com.xm.service;

import com.xm.entity.CameraInfo;
import com.xm.mapper.CameraInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CameraInfoService {
    @Autowired
    CameraInfoMapper cameraInfoMapper;

    public List<CameraInfo> find(){
        List<CameraInfo> allCameraInfo = cameraInfoMapper.getAllCameraInfo();
        return allCameraInfo;
    }

}
