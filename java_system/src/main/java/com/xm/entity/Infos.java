package com.xm.entity;

import org.springframework.stereotype.Component;

/**
 *  数据库同步 测试示例
 *
 */
@Component
public class Infos {
    private int groupId;
    private String userId;
    private String imgFeature;

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getImgFeature() {
        return imgFeature;
    }

    public void setImgFeature(String imgFeature) {
        this.imgFeature = imgFeature;
    }
}
