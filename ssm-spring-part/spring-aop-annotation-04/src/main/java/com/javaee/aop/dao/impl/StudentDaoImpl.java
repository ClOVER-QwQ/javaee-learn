package com.javaee.aop.dao.impl;

import com.javaee.aop.dao.StudentDao;
import com.javaee.aop.po.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {

    @Override
    public int insertStudent(Student student) {
        return 0;
    }

    @Override
    public int deleteByNum(String snum) {
        return 0;
    }

    @Override
    public int deleteMulti(int[] ids) {
        return 0;
    }

    @Override
    public int update(int sid, String sname, int sage) {
        return 0;
    }

    @Override
    public Student selectById(int sid) {
        return null;
    }

    @Override
    public Student selectByParam(String columnName, Object paramValue) {
        return null;
    }

    @Override
    public List<Student> queryByMultiParam(Student student) {
        return null;
    }
}
