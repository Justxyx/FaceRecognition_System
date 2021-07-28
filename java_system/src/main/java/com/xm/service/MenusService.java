package com.xm.service;

import com.xm.entity.Menus;
import com.xm.mapper.MenusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MenusService {
    @Autowired
    MenusMapper menusMapper;

    public List<Menus> findAllMenus(){
        List<Menus> firstLevel = menusMapper.findAllOne();
        for(Menus menus:firstLevel){
            List<Menus> children = new ArrayList<Menus>();
            if(menus.getChildrenList() != null){
               String str = menus.getChildrenList();
                String[] as = str.split(",");
                int[] array =  Arrays.stream(as).mapToInt(Integer::parseInt).toArray();
                for(int i = 0;i<array.length;i++){
                    Menus menusChil = menusMapper.findById(array[i]);
                    children.add(menusChil);
                }
            }
            menus.setChildren(children);
        }
        return firstLevel;
    }




}
