package com.xm.mapper;


import com.xm.entity.TestTime;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Mapper
@Repository
public interface TimeTestMapper {
    List<TestTime> find();
    void add(@Param("str")Timestamp str);
}
