package com.javaee.dynamicQuery.dao;

import com.javaee.dynamicQuery.po.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    private Connection conn = null;
    private PreparedStatement pstm = null;
    private ResultSet rs = null;

    private Connection getConnetion(){
        return null;
    }

    private String chooseOne(String number,String name){
        StringBuffer sql = new StringBuffer("select * from student where 1=1");
        if(number!=null && !number.isBlank()){
            sql.append(" and number like concat('%',"+number+",'%')");
        }else if(name!=null && !name.isBlank()){
            sql.append(" and name like concat('%',"+name+",'%')");
        }else{
            sql.append(" and age>30");
        }
        return sql.toString();
    }

    private String assembleSql(String number,String name,int age){
        StringBuffer sql = new StringBuffer("select * from student");
        boolean isExistWhere = false;
        if(number!=null && !number.isBlank()){
            sql.append(" where number='"+number+"'");
            isExistWhere = true;
        }
        if(name!=null && !name.isBlank()){
            if(!isExistWhere){
                isExistWhere = true;
                sql.append(" where name like '%"+name+"%'");
            }else sql.append("and name like '%"+name+"%'");
        }
        if(age>0){
            if(!isExistWhere){
                isExistWhere = true;
                sql.append(" where age="+age);
            }else sql.append(" and age="+age);
        }
        return sql.toString();
    }

    private String assembleSql0(String number,String name,int age){
        StringBuffer sql = new StringBuffer("select * from student where 1=1");
        if(number!=null && !number.isBlank()){
            sql.append(" and number like concat('%',"+number+",'%')");
        }
        if(name!=null && !name.isBlank()){
            sql.append(" and name like concat('%',"+name+",'%')");
        }
        if(age>0){
            sql.append(" and age="+age);
        }
        return sql.toString();
    }
    public List<Student> queryByMultiParam(String number,String name,int age) {
        String sql= assembleSql0(number,name,age);
        List<Student> list = new ArrayList<>();
        try {
            conn = getConnetion();
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while(rs.next()){
                Student stu = new Student();
                stu.setId(rs.getInt("id"));
                stu.setNumber(rs.getString("number"));
                stu.setName(rs.getString("name"));
                stu.setAge(rs.getInt("age"));
                stu.setIntro(rs.getString("intro"));
                list.add(stu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(conn,pstm,rs);
        }
        return list;
    }

    private void close(Connection conn, PreparedStatement pstm, ResultSet rs) {

    }

}

