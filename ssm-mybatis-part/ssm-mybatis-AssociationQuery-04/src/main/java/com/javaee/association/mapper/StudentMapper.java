package com.javaee.association.mapper;

import com.javaee.association.po.Student;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

public interface StudentMapper {

    List<Student> selectByBjid(int bjId);

    //嵌套查询
    Student selectWithBj(int id);

    //嵌套结果
    Student selectJoinBj(int id);
}
