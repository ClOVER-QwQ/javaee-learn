package com.javaee.association.test;


import com.javaee.association.mapper.BjclassMapper;
import com.javaee.association.po.Bjclass;
import com.javaee.association.po.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class BjclassMapperTest {

    private SqlSession sqlSession;

    @BeforeEach
    public void before() throws IOException {
        //1.创建SqlSessionFactory对象
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        //2.通过sessionFactory对象开启一个SqlSession对象
        sqlSession = sessionFactory.openSession(true);
    }

    @AfterEach
    public void close(){
        sqlSession.close();
    }

    @Test
    public void testSelectById(){
        BjclassMapper mapper = sqlSession.getMapper(BjclassMapper.class);
        Bjclass bjclass = mapper.selectById(1);
        System.out.println("bjclass = " + bjclass);
    }

    @Test
    public void testSelectByIdWithStudent(){
        BjclassMapper mapper = sqlSession.getMapper(BjclassMapper.class);
        Bjclass bjclass = mapper.selectByIdWithStudent(1);
        System.out.println("bjclass = " + bjclass);
        for (Student stu:bjclass.getStudents()) {
            System.out.println("stu = " + stu);
        }
    }
    @Test
    public void testSelectByIdJoinStudent(){
        BjclassMapper mapper = sqlSession.getMapper(BjclassMapper.class);
        Bjclass bjclass = mapper.selectByIdJoinStudent(1);
        System.out.println("bjclass = " + bjclass);
        for (Student stu:bjclass.getStudents()) {
            System.out.println("stu = " + stu);
        }
    }

}