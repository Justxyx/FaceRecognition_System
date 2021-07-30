package com.xm.mapper;

import com.xm.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface UserMapper {
    User findUserByPassword(@Param("id") long id,@Param("gId") int gId);
    List<User> getUserList(@Param("gId") int gId );
    Boolean addUser(@Param("user") User user);
}
