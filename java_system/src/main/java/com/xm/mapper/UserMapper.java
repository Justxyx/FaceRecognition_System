package com.xm.mapper;

import com.xm.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;



@Mapper
@Repository
public interface UserMapper {
    User findUserByPassword(@Param("id") long id);
}
