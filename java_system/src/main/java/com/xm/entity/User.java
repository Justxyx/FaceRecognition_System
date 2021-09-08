package com.xm.entity;

import org.springframework.stereotype.Component;

@Component
public class User {
    private String userId;     // 对应用户id
    private String userName;
    private String userPassword;
    private int groupId;    // 对应公司id
    private String department;   // 对应公司部门，保留字段，不一定使用
    private int gender;  // 性别  0女  1 男
    private long userTel;
    private String imgPath;  //对应用户图片路径
    private String imgFeature; // 对应用户特征
    private String imgBase64;
    private int role;   // 用户权限   0 1 2  依次为   user groupAdmin root
    private String token; // 存储token
    private String email;

    public String getImgBase64() {
        return imgBase64;
    }

    public void setImgBase64(String imgBase64) {
        this.imgBase64 = imgBase64;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public long getUserTel() {
        return userTel;
    }

    public void setUserTel(long userTel) {
        this.userTel = userTel;
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
