package com.javaee.aop.service.impl;

import com.javaee.aop.dao.StudentDao;
import com.javaee.aop.po.Student;
import com.javaee.aop.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public int insertStudent(Student student) {
        int result=0;
        Student stu= studentDao.selectByParam("number",student.getNumber());
        if(stu==null){
            result = studentDao.insertStudent(student);
            System.out.println("成功保存到数据库！");
        }else{
            System.out.println("数据库中已存在该学号！");
        }
        return result;
    }

    @Override
    public int deleteByNum(String snum) {
        return studentDao.deleteByNum(snum);
    }

    @Override
    public int deleteMulti(int[] ids) {
        return studentDao.deleteMulti(ids);
    }

    @Override
    public int update(int sid, String sname, int sage) {
        return studentDao.update(sid, sname, sage);
    }

    @Override
    public Student selectById(int sid) {
        return studentDao.selectById(sid);
    }

    @Override
    public List<Student> queryByMultiParam(Student student) {
        return studentDao.queryByMultiParam(student);
    }
}