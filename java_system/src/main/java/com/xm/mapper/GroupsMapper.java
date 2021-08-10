package com.xm.mapper;

import com.xm.entity.Group;
import com.xm.entity.Menus;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface GroupsMapper {
    List<Group> findAllGroups();
}
