package com.javaee.dynamicQuery.dao;

import com.javaee.dynamicQuery.po.Student;

import java.util.List;

public interface StudentDao {

    //1.1 <if>的使用
    //根据学号、姓名和年龄等多条件组合查询出符合条件的学生
    List<Student> queryByMultiParam1(Student student);
}
