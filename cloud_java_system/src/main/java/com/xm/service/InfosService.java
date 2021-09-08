package com.xm.service;

import com.xm.entity.Infos;
import com.xm.mapper.InfosMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfosService {
    @Autowired
    InfosMapper infosMapper;

    public boolean addInfos(Infos infos){
        try {
            infosMapper.addInfos(infos);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean deleteInfos(String userId){
        try {
            infosMapper.deleteInfos(userId);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
