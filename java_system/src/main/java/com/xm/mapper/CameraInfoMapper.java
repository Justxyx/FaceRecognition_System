package com.xm.mapper;

import com.xm.entity.CameraInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CameraInfoMapper {
    List<CameraInfo> getAllCameraInfo(@Param("startPage") int startPage , @Param("endPage") int endPage);
    int getCountCamerInfo();
}
