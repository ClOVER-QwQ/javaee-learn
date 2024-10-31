package com.javaee.service;
import com.javaee.dao.StudentDao;
public class StudentService {
    //1 声明但不赋值
    private StudentDao studentDao;

    //2.1 提供setter方法
    public void setStudentDao(StudentDao sDao){
        studentDao = sDao;
    }
    //2.2 无参构造方法
    public StudentService(){ }

    //构造注入，提供有参构造方法
    public StudentService(StudentDao sDao){
        studentDao = sDao;
    }

    public void addStudent(){
        System.out.println("执行StudentService的addStudent()方法-开始");
        studentDao.insertStudent();
        System.out.println("执行StudentService的addStudent()方法-完毕");
    }

}