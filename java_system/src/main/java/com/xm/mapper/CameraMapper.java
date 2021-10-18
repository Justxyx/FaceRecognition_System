package com.xm.mapper;


import com.xm.entity.Camera;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CameraMapper {
    boolean addCamera(@Param("camera") Camera camera);
    List<Camera> cameraList(@Param("startPage") int startPage , @Param("endPage") int endPage);
    int cameraCount();
    boolean deleteCameraById(@Param("cId") long cId);
}
