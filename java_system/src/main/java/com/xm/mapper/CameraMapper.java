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
    List<Camera> cameraList(@Param("gId") int gId);
    boolean deleteCameraById(@Param("gId") int gId,@Param("cId") long cId);
}
