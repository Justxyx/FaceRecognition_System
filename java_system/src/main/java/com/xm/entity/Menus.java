package com.xm.entity;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Menus {
    private int id;
    private String authName;
    private String path;
    private int isChildren;  // 判断是一级菜单还是二级菜单
    private String childrenList;  // 二级菜单列表
    private List<Menus> children;

    public List<Menus> getChildren() {
        return children;
    }

    public void setChildren(List<Menus> children) {
        this.children = children;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getIsChildren() {
        return isChildren;
    }

    public void setIsChildren(int isChildren) {
        this.isChildren = isChildren;
    }

    public String getChildrenList() {
        return childrenList;
    }

    public void setChildrenList(String childrenList) {
        this.childrenList = childrenList;
    }

    @Override
    public String toString() {
        return "Menus{" +
                "id=" + id +
                ", authName='" + authName + '\'' +
                ", path='" + path + '\'' +
                ", isChildren=" + isChildren +
                ", childrenList='" + childrenList + '\'' +
                ", children=" + children +
                '}';
    }
}
