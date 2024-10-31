package com.javaee.service;

import com.javaee.dao.StudentDao;

import java.sql.SQLOutput;

public class CourseService {

    private StudentDao studentDao= new StudentDao();

    public void addSorces(String course,String stuNum,double sorce){
        int stuId = studentDao.selectByNum(stuNum);
        System.out.println("模拟将学生id，课程和成绩保存到数据库");
    }

}
