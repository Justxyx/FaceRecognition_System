package com.xm.entity;

import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class Group {
    private int groupId;
    private String groupName;
    private Date groupDate;   //  小组创建时间
    private int userId;    //  创建人id
    private User user;      // 对应创建人详情，此字段不存储数据库，只方便封装。


    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Date getGroupDate() {
        return groupDate;
    }

    public void setGroupDate(Date groupDate) {
        this.groupDate = groupDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
