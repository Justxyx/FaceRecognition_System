package com.xm.entity;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author xm
 * @date 2021/10/15 11:11
 * @description:
 */
@Component
public class PageBean<T> {
        private List<T> lists;// 存放需要显示的实体类数据
        private Integer pageNo = 1;// 当前页码数（默认给1），需要传参
        private Integer pageSize; // 每页显示的行数，需要传参
     // this.totalPage = rows % pageSize == 0 ? rows / pageSize : (rows / pageSize + 1);
        private Integer totalPage;// 总页数，是根据总行数和每页显示的行数计算出来的结果
        private Integer rows;// 总行数，总行数是查询出来的数据表总记录数

    public List<T> getLists() {
        return lists;
    }

    public void setLists(List<T> lists) {
        this.lists = lists;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
}

