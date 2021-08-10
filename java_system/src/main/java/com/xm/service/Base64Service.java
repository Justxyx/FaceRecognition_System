package com.xm.service;

import sun.misc.BASE64Decoder;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Base64Service {
    public static boolean saveBase64Img(String base64Img,int path1,long path2){
        String base64 = base64Img.replace("%2F", "/");
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] data = new byte[0];
        try {
            data = decoder.decodeBuffer(base64);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(int i =0 ; i < data.length ;i++) {
            if(data[i] < 0) {
                data[i] += 256;
            }
        }
        //写入保存成jpeg文件
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("D:\\project\\face_system\\FaceRecognition_System\\vue_system\\static\\register\\" +path1+"\\" +path2+".jpeg");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            fos.write(data);
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
        return true;
    }
}
