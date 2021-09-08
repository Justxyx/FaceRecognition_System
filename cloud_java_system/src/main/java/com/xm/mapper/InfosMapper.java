package com.xm.mapper;

import com.xm.entity.Infos;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface InfosMapper {

    Boolean addInfos(@Param("infos") Infos infos);
    boolean deleteInfos(@Param("userId") String userId );
}
