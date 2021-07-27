package com.xm.entity;

import org.springframework.stereotype.Component;

@Component
public class User {
    private int userId;     // 对应用户id
    private int groupId;    // 对应公司id
    private String userName;
    private String userPassword;
    private String gender;  // 性别  0女  1 男
    private String email;
    private String imgPath;  //对应用户图片路径
    private String imgFeature; // 对应用户特征
    private int role;   // 用户权限   0 1 2  依次为root groupAdmin user
    private String token; // 存储token


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getImgFeature() {
        return imgFeature;
    }

    public void setImgFeature(String imgFeature) {
        this.imgFeature = imgFeature;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
