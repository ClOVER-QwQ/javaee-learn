package com.javaee.aop.service.impl;

import com.javaee.aop.component.OpLog;
import com.javaee.aop.dao.StudentDao;
import com.javaee.aop.po.Student;
import com.javaee.aop.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//添加操作日志，记录每个方法被调用的时间，以及类明和方法名，以及参数

/**方案2：
 * 1）将记录操作日志代码的代码提取出来进行封装，参照OpLog类的saveServiceMethodInvoke方法
 * 2）在service的每个方法中调用OpLog类的saveServiceMethodInvoke方法
 - 解决了代码重复问题
 - 但调用方法分散在各个业务功能方法中，仍不便于统一维护！
 - 对核心业务功能有干扰，导致程序员在开发核心业务功能时分散了精力
 */
@Service
public class StudentServiceImpl02 implements StudentService {
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private OpLog opLog;
    @Override
    public int deleteByNum(String snum) {
        //方案2：添加操作日志开始
        opLog.saveServiceMethodInvoke("StudentServiceImpl01",
                "deleteByNum",new Object[]{snum});
        //方案2：添加操作日志结束
        return studentDao.deleteByNum(snum);
    }

    public int insertStudent(Student student) {
        //方案2：添加操作日志开始
        opLog.saveServiceMethodInvoke("StudentServiceImpl01",
                "insertStudent",new Object[]{student});
        //方案2：添加操作日志结束
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