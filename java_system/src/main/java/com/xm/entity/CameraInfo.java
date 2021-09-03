package com.xm.entity;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * 人脸识别图像
 */
@Component
public class CameraInfo {
    private long imgInfoId;     // 主键

    private int infoId;
    private int cameraId;
    private Timestamp infoTime;
    private long pId;
    private double pSocer;
    private String cameraIp;
    private String cameraPosition;
    private String imgPath;  // 用户注册头像照片
    private String imgSrc;      // 用户现场照片
    private String userName;

    private User user;
    private Camera camera;

    @Override
    public String toString() {
        return "CameraInfo{" +
                "infoId=" + infoId +
                ", cameraId=" + cameraId +
                ", infoTime=" + infoTime +
                ", pId=" + pId +
                ", pSocer=" + pSocer +
                ", cameraIp='" + cameraIp + '\'' +
                ", cameraPosition='" + cameraPosition + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", imgSrc='" + imgSrc + '\'' +
                ", user=" + user +
                ", camera=" + camera +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getImgInfoId() {
        return imgInfoId;
    }

    public void setImgInfoId(long imgInfoId) {
        this.imgInfoId = imgInfoId;
    }

    public int getInfoId() {
        return infoId;
    }

    public void setInfoId(int infoId) {
        this.infoId = infoId;
    }

    public int getCameraId() {
        return cameraId;
    }

    public void setCameraId(int cameraId) {
        this.cameraId = cameraId;
    }

    public Timestamp getInfoTime() {
        return infoTime;
    }

    public void setInfoTime(Timestamp infoTime) {
        this.infoTime = infoTime;
    }

    public long getpId() {
        return pId;
    }

    public void setpId(long pId) {
        this.pId = pId;
    }

    public double getpSocer() {
        return pSocer;
    }

    public void setpSocer(double pSocer) {
        this.pSocer = pSocer;
    }

    public String getCameraIp() {
        return cameraIp;
    }

    public void setCameraIp(String cameraIp) {
        this.cameraIp = cameraIp;
    }

    public String getCameraPosition() {
        return cameraPosition;
    }

    public void setCameraPosition(String cameraPosition) {
        this.cameraPosition = cameraPosition;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Camera getCamera() {
        return camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }
}
