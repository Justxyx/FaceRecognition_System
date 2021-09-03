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

    public List<User> getUserList(){
        List<User> userList = userMapper.getUserList();
        return userList;
    }

    public boolean addUser(User user){
        user.setUserPassword(String.valueOf(user.getUserId()));
        Base64Service.saveBase64Img(user.getImgBase64(),user.getGroupId(),user.getUserId());
        user.setImgPath("static\\register\\" + user.getGroupId()+"\\" + user.getUserId() + ".jpeg");
        user.setRole(0);
        try {
            Boolean aBoolean = userMapper.addUser(user);
        } catch (Exception e) {
            System.out.println("添加用户失败");
            return false;
        }
        return true;
    }

    public boolean deleteUserById(long userId){
        try {
            Boolean aBoolean = userMapper.deleteUserById(userId);
        } catch (Exception e) {
            System.out.println("删除用户失败");
            return false;
        }
        return true;
    }
}
