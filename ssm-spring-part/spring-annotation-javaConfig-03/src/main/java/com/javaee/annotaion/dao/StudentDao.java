package com.javaee.annotaion.dao;

import com.javaee.annotaion.po.Student;

public interface StudentDao {
    public int insertStudent(Student student);

    //查询指定学号的学生是否存在，存在返回1，否则返回0
    public int selectByNum(String num);
}
