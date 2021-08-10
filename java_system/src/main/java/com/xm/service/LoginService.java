package com.xm.service;

import com.xm.entity.Group;
import com.xm.entity.User;
import com.xm.mapper.GroupsMapper;
import com.xm.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    GroupsMapper groupsMapper;

    public User findUserByPassword(long id,int gId){
        User user = userMapper.findUserByPassword(id,gId);
        return user;
    }

    public List<Group>  findAllGroups(){
        List<Group> allGroups = groupsMapper.findAllGroups();
        return allGroups;
    }
}
