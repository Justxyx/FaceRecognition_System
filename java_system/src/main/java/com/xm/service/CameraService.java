package com.xm.service;

import com.xm.entity.Camera;
import com.xm.entity.PageBean;
import com.xm.mapper.CameraMapper;
import com.xm.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CameraService {
    @Autowired
    CameraMapper cameraMapper;

    @Autowired
    PageBean pageBean;

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


    public PageBean cameraList(String pageNo, String pageSize){
        int count = cameraMapper.cameraCount();
        pageBean.setRows(count);
        pageBean.setPageNo(Integer.valueOf(pageNo));
        pageBean.setPageSize(Integer.valueOf(pageSize));
        int totalPage;
        int startPage;
        int endPage;
        startPage = (Integer.valueOf(pageNo) - 1)*Integer.valueOf(pageSize);
        endPage =  Integer.valueOf(pageSize);
        if (Integer.valueOf(count)%Integer.valueOf(pageSize) == 0){
            totalPage = Integer.valueOf(count)/Integer.valueOf(pageSize) ;
        }else {
            totalPage = Integer.valueOf(count)/Integer.valueOf(pageSize) + 1;
            if (endPage == totalPage){
                endPage = Integer.valueOf(count)%Integer.valueOf(pageSize);
            }
        }
        pageBean.setTotalPage(totalPage);
        List<Camera> cameraList = null;
        try {
            cameraList = cameraMapper.cameraList(startPage,endPage);
        } catch (Exception e) {
            // 后期加日志系统
            System.out.println("查询失败");
        }
        pageBean.setLists(cameraList);
        return pageBean;
    }

    public boolean deleteCameraById(String id){
        int gId = JwtUtils.tokenGroupId();
        long cid = Integer.parseInt(id);
        boolean b;
        try {
            cameraMapper.deleteCameraById( cid);
            b = true;
        } catch (Exception e) {
            System.out.println("删除失败");
            b = false;
        }
        return b;
    }
}
