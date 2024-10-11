package com.javaee.association.test;

import com.javaee.association.mapper.StudentMapper;
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

public class StudentMapperTest {

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

    //嵌套查询
    //Student selectWithBj(int id);
    @Test
    public void testSelectWithBj(){
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.selectWithBj(7);
        System.out.println("student = " + student);
        System.out.println("student.bj = " + student.getBjclass());
    }

    //嵌套结果
    //Student selectJoinBj(int id);
    @Test
    public void testSelectJoinBj(){
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.selectJoinBj(7);
        System.out.println("student = " + student);
        System.out.println("student.bj = " + student.getBjclass());
    }
}
