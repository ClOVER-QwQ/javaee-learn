package com.javaee.association.mapper;

import com.javaee.association.po.Bjclass;

public interface BjclassMapper {

    Bjclass selectById(int bjId);

    //嵌套查询
    Bjclass selectByIdWithStudent(int bjId);

    //嵌套结果
    Bjclass selectByIdJoinStudent(int bjId);
}
