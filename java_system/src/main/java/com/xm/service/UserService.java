package com.xm.service;

import com.xm.entity.User;
import com.xm.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public List<User> getUserList(int gId){
        List<User> userList = userMapper.getUserList(gId);
        return userList;
    }

    public boolean addUser(User user){
        user.setUserPassword(String.valueOf(user.getUserId()));
        user.setRole(0);
        try {
            Boolean aBoolean = userMapper.addUser(user);
        } catch (Exception e) {
            System.out.println("添加用户失败");
            return false;
        }
        return true;
    }

    public boolean deleteUserById(int userId,int gId){
        try {
            Boolean aBoolean = userMapper.deleteUserById(userId, gId);
        } catch (Exception e) {
            System.out.println("删除用户失败");
            return false;
        }
        return true;
    }
}
