package com.javaee.input.test;

import com.javaee.input.mapper.StudentMapper;
import com.javaee.input.po.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MybatisTest {

    @Test
    public void testSelectById() throws IOException {
        //1.创建SqlSessionFactory对象
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        //2.通过sessionFactory对象开启一个SqlSession对象
        SqlSession sqlSession = sessionFactory.openSession();

        //3.通过sqlSession获取mapper接口的代理对象
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        //4.调用接口代理对象去执行数据库操作
        Student student = mapper.selectById(1);
        System.out.println("student = " + student);
        //5.关闭
        sqlSession.close();
    }

    @Test
    public void testUpdate() throws IOException {
        //1.创建SqlSessionFactory对象
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        //2.通过sessionFactory对象开启一个SqlSession对象
        SqlSession sqlSession = sessionFactory.openSession();
        //3.通过sqlSession获取mapper接口的代理对象
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        //4.调用接口代理对象去执行数据库操作
        mapper.update(1,"杨清平",20); //1  杨清平  20
        //5.关闭
        sqlSession.close();
        //观察数据库数据被修改了吗？
    }

    @Test
    public void testUpdate2() throws IOException {
    }

}
