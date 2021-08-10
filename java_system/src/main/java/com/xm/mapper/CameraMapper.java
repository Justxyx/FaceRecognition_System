package com.xm.mapper;


import com.xm.entity.Camera;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CameraMapper {

    boolean addCamera(@Param("camera") Camera camera);
}
