package com.xm.mapper;

import com.xm.entity.PageBean;
import com.xm.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface UserMapper {
    User findUserByPassword(@Param("id") String id);
    int getCount();
    List<User> getUserList(@Param("startPage") int startPage ,@Param("endPage") int endPage);
    Boolean addUser(@Param("user") User user);
    Boolean deleteUserById (@Param("userId") String userId);
}
