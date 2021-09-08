package com.xm.mapper;

import com.xm.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface UserMapper {
    User findUserByPassword(@Param("id") String id);
    List<User> getUserList( );
    Boolean addUser(@Param("user") User user);
    Boolean deleteUserById (@Param("userId") String userId);
}
