package com.xm.entity;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Camera {
    private int cameraId;
    private int groupId;    // 摄像头对应groupId
    private String cameraUId;    // 对应唯一表示摄像机编码
    private String cameraLocation;     // 摄像头的坐标信息
    private String cameraPositon;    // 摄像头位置信息,文字描述。
    private String cameraSrc;  //摄像头网络地址
    private Date cameraDate;   // 摄像头接入时间
    private int userId;    //  创建人id
    private User user;      // 对应创建人详情，此字段不存储数据库，只方便封装。
}
