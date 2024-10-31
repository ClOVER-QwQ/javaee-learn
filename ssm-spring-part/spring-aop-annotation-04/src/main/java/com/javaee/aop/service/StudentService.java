package com.javaee.aop.service;

import com.javaee.aop.po.Student;

import java.util.List;

public interface StudentService {
    //添加
    int insertStudent(Student student);
    //根据学号删除
    int deleteByNum(String snum);
    //批量删除
    int deleteMulti(int[] ids);
    //根据id修改姓名和年龄
    int update(int sid,String sname,int sage);
    //根据id查询
    Student selectById(int sid);

    //根据学号、姓名和年龄等多条件组合查询出符合条件的学生
    List<Student> queryByMultiParam(Student student);
}
