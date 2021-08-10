package com.xm.entity;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Camera {
    private long cameraId;
    private String serialNumber;
    private int groupId;    // 摄像头对应groupId

    private String cameraName;
    private String cameraPwd;
    private String  cameraIp;
    private int cameraPort;


    private String cameraLocation;     // 摄像头的坐标信息
    private String cameraPosition;    // 摄像头位置信息,文字描述。
    private String cameraSrc;  //摄像头网络地址
    private Date cameraDate;   // 摄像头接入时间

    public int getCameraPort() {
        return cameraPort;
    }

    public void setCameraPort(int cameraPort) {
        this.cameraPort = cameraPort;
    }

    public long getCameraId() {
        return cameraId;
    }

    public void setCameraId(long cameraId) {
        this.cameraId = cameraId;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getCameraName() {
        return cameraName;
    }

    public void setCameraName(String cameraName) {
        this.cameraName = cameraName;
    }

    public String getCameraPwd() {
        return cameraPwd;
    }

    public void setCameraPwd(String cameraPwd) {
        this.cameraPwd = cameraPwd;
    }

    public String getCameraIp() {
        return cameraIp;
    }

    public void setCameraIp(String cameraIp) {
        this.cameraIp = cameraIp;
    }

    public String getCameraLocation() {
        return cameraLocation;
    }

    public void setCameraLocation(String cameraLocation) {
        this.cameraLocation = cameraLocation;
    }

    public String getCameraPosition() {
        return cameraPosition;
    }

    public void setCameraPosition(String cameraPosition) {
        this.cameraPosition = cameraPosition;
    }

    public String getCameraSrc() {
        return cameraSrc;
    }

    public void setCameraSrc(String cameraSrc) {
        this.cameraSrc = cameraSrc;
    }

    public Date getCameraDate() {
        return cameraDate;
    }

    public void setCameraDate(Date cameraDate) {
        this.cameraDate = cameraDate;
    }
}
