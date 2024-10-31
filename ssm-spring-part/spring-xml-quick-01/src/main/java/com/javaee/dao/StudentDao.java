package com.javaee.dao;

public class StudentDao {

    public StudentDao(){
    }
    public void insertStudent(){
        System.out.println("正在执行StudentDao的insertStudent()方法");
    }
    //根据学号查询出id
    public int selectByNum(String num){
        System.out.println("正在执行StudentDao的selectByNum()方法");
        return 1;
    }
}
