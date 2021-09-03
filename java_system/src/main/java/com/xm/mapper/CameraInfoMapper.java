package com.xm.mapper;

import com.xm.entity.CameraInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CameraInfoMapper {
    List<CameraInfo> getAllCameraInfo();
}
