package com.xm.service;

import com.xm.entity.User;
import com.xm.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    UserMapper userMapper;

    public User findUserByPassword(long id){
        User user = userMapper.findUserByPassword(id);
        return user;
    }
}
