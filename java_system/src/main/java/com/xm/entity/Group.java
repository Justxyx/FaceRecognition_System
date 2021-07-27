package com.xm.entity;

import java.util.Date;
import java.util.List;

public class Group {
    private int groupId;
    private String groupName;
    private Date groupDate;   //  小组创建时间
    private int userId;    //  创建人id
    private User user;      // 对应创建人详情，此字段不存储数据库，只方便封装。
}
