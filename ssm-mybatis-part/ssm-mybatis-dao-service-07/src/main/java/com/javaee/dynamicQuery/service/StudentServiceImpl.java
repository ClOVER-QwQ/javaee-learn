package com.javaee.dynamicQuery.service;

import com.javaee.dynamicQuery.dao.StudentDao;
import com.javaee.dynamicQuery.dao.StudentDaoImpl;
import com.javaee.dynamicQuery.po.Student;

import java.util.List;

public class StudentServiceImpl implements StudentService{

    private StudentDao studentDao=new StudentDaoImpl();

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public List<Student> queryByMultiParam1(Student student) {
        return studentDao.queryByMultiParam1(student);
    }
}
