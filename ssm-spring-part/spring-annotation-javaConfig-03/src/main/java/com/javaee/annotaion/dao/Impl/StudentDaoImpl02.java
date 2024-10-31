package com.javaee.annotaion.dao.Impl;

import com.javaee.annotaion.dao.StudentDao;
import com.javaee.annotaion.po.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("stuDao2")
public class StudentDaoImpl02 implements StudentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int insertStudent(Student s) {
        System.out.println("正在执行Dao类的insert方法");
        int rowCount=0;
        String sql="insert into student(number,name,age,intro) values(?,?,?,?)";
        try {
            rowCount = jdbcTemplate.update(sql,s.getNum(),s.getName(),s.getAge(),s.getIntro());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return rowCount;
    }
    public int selectByNum(String num) {
        System.out.println("正在执行Dao2类的selectByNum方法");
        String sql="select COUNT(*) from student where number="+num;
        int total = jdbcTemplate.queryForObject(sql,Integer.class);
        return total;
    }
}
