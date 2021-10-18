package com.xm.service;

import com.xm.entity.Infos;
import com.xm.entity.PageBean;
import com.xm.entity.User;
import com.xm.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    Infos infos;

    @Autowired
    PageBean pageBean;


    public PageBean getUserList(String pageNo, String pageSize){
        int count = userMapper.getCount();  // 总条数
        pageBean.setRows(count);
        pageBean.setPageNo(Integer.valueOf(pageNo));
        pageBean.setPageSize(Integer.valueOf(pageSize));

        int totalPage;
        int startPage;
        int endPage;
        startPage = (Integer.valueOf(pageNo) - 1)*Integer.valueOf(pageSize);
        endPage =  Integer.valueOf(pageSize);
        if (Integer.valueOf(count)%Integer.valueOf(pageSize) == 0){
            totalPage = Integer.valueOf(count)/Integer.valueOf(pageSize) ;
        }else {
            totalPage = Integer.valueOf(count)/Integer.valueOf(pageSize) + 1;
            if (endPage == totalPage){
                endPage = Integer.valueOf(count)%Integer.valueOf(pageSize);
            }
        }
        pageBean.setTotalPage(totalPage);
        List<User> userList = userMapper.getUserList(startPage,endPage);
        pageBean.setLists(userList);
        return pageBean;
    }

    public boolean addUser(User user){
        user.setUserPassword(user.getUserId());
        Base64Service.saveBase64Img(user.getImgBase64(),user.getGroupId(),user.getUserId());
//        user.setImgPath("static\\register\\" + user.getGroupId()+"\\" + user.getUserId() + ".jpeg");
        String path = "static\\register\\" + user.getGroupId()+"\\" + user.getUserId() + ".jpeg";
        user.setImgPath(path);
//        user.setImgPath("staticregister");
        user.setRole(0);
        try {
            Boolean aBoolean = userMapper.addUser(user);
        } catch (Exception e) {
            System.out.println("添加用户失败");
            return false;
        }
        // 封装infos
        infos.setUserId(user.getUserId());
        infos.setGroupId(user.getGroupId());
        infos.setImgFeature(user.getImgFeature());

        // 发送url请求数据库同步
        String url = "http://192.168.0.101:8082/add";
        RestTemplate restTemplate = new RestTemplate();
        Boolean b = restTemplate.postForObject(url,infos, Boolean.class);
        if (b){
            // 请求成功
            return b;
        }else {
            // 请求失败
            Boolean aBoolean = userMapper.deleteUserById(user.getUserId());
            return false;
        }

    }

    public boolean deleteUserById(String userId){

        try {
            String url = "http://192.168.0.101:8082/delete";
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.postForObject(url,userId, Boolean.class);
            Boolean aBoolean = userMapper.deleteUserById(userId);
        } catch (Exception e) {
            System.out.println("删除用户失败");

            return false;
        }
        return true;
    }
}
