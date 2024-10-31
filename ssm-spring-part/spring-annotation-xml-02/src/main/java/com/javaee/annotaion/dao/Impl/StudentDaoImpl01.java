package com.javaee.annotaion.dao.Impl;

import com.alibaba.druid.pool.DruidDataSource;
import com.javaee.annotaion.po.Student;
import com.javaee.annotaion.dao.StudentDao;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


//@Repository  //等价@Repository("studentDaoImpl01")
@Repository("stuDao1")
public class StudentDaoImpl01 implements StudentDao {
    private DruidDataSource druidDataSource;
    private JdbcTemplate jdbcTemplate;

    /*
     <dataSource type="POOLED">
        <!-- 数据库连接的具体信息 -->
        <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
        <property name="url" value="jdbc:mysql://localhost:3306/javaeedb?serverTimezone=UTC"/>
        <property name="username" value="javaee"/>
        <property name="password" value="javaee1234"/>
    </dataSource>
 */
    public StudentDaoImpl01(){
        druidDataSource=new DruidDataSource();
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/javaeedb?serverTimezone=UTC");
        druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        druidDataSource.setUsername("javaee");
        druidDataSource.setPassword("javaee1234");

        jdbcTemplate=new JdbcTemplate();
        jdbcTemplate.setDataSource(druidDataSource);
    }

    public int insertStudent(Student s) {
        System.out.println("正在执行Dao1类的insert方法");
        int rowCount=0;
        String sql="insert into student(number,name,age,intro) values(?,?,?,?)";
        rowCount = jdbcTemplate.update(sql,s.getNum(),s.getName(),s.getAge(),s.getIntro());
        return rowCount;
    }

    public int selectByNum(String num) {
        System.out.println("正在执行Dao1类的selectByNum方法");
        String sql="select COUNT(*) from student where number="+num;
        int total = jdbcTemplate.queryForObject(sql,Integer.class);
        return total;
    }
}
