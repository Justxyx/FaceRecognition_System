package com.xm.mapper;

import com.xm.entity.Menus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MenusMapper {
    List<Menus> findAllOne();  // 查找所有的一级菜单
    Menus findById(@Param("id") int id);
}
