package com.xm.service;

import com.xm.entity.CameraInfo;
import com.xm.entity.PageBean;
import com.xm.mapper.CameraInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CameraInfoService {
    @Autowired
    CameraInfoMapper cameraInfoMapper;

    @Autowired
    PageBean pageBean;

    public PageBean find(String pageNo, String pageSize){
        int count = cameraInfoMapper.getCountCamerInfo();
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
        List<CameraInfo> allCameraInfo = cameraInfoMapper.getAllCameraInfo(startPage,endPage);
        pageBean.setLists(allCameraInfo);
        return pageBean;
    }

}
