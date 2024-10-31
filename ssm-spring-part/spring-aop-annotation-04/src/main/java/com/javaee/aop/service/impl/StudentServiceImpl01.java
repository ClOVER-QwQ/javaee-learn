package com.javaee.aop.service.impl;

import com.javaee.aop.dao.StudentDao;
import com.javaee.aop.po.Student;
import com.javaee.aop.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//添加操作日志，记录每个方法被调用的时间，以及类明和方法名，以及参数
/**方案1：在每个方法中添加日志代码
 1. 代码缺陷
 - 代码重复，分散在各个业务功能方法中！冗余，且不方便统一维护！
 - 对核心业务功能有干扰，导致程序员在开发核心业务功能时分散了精力
 */
@Service
public class StudentServiceImpl01 implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public int insertStudent(Student student) {
        //方案1：添加操作日志开始
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println("调用时间：" + currentTimeMillis);
        System.out.println("className = StudentServiceImpl01");
        System.out.println("methodName = insertStudent");
        System.out.println("arg = " + student);
        //方案1：添加操作日志结束
        int result=0;
        Student stu= studentDao.selectByParam("number",
                                               student.getNumber());
        if(stu==null){
            result = studentDao.insertStudent(student);
        }else{
            System.out.println("数据库中已存在该学号！");
        }
        return result;
    }

    @Override
    public int deleteByNum(String snum) {
        //方案1：添加操作日志开始
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println("调用时间：" + currentTimeMillis);
        System.out.println("className = StudentServiceImpl01");
        System.out.println("methodName = deleteByNum");
        System.out.println("arg = " + snum);
        //方案1：添加操作日志结束
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