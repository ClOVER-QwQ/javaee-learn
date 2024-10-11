package com.javaee.output.test;

import com.javaee.output.mapper.StudentMapper;
import com.javaee.output.po.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class MybatisTest {

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

    //0 DML操作不需要指定,自动返回操作影响的行数
    //int deleteById(int sid);
    @Test
    public void testDeleteById(){
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        int count = mapper.deleteById(1);
        System.out.println("count = " + count);
    }

    //1 返回单个简单类型
    @Test
    public void testSelectStudentCount(){
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        int count = mapper.selectStudentCount();
        System.out.println("count = " + count);
    }

    @Test
    public void testSelectStudentName(){
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        String name = mapper.selectNameById(7);
        System.out.println("name = " + name);
    }

    //2 返回实体类对象
    @Test
    public void testSelectById(){
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.selectById(7);
        System.out.println("student = " + student);
    }

    //3 返回Map类型
    @Test
    public void testSelectAgeCount(){
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Map<String, Integer> ageMap = mapper.selectAgeCount(30);
        System.out.println("ageMap = " + ageMap);
    }

    //4 返回List类型
    @Test
    public void testSelectAll(){
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.selectAll();
        for(Student student:students){
            System.out.println("student = " + student);
        }
    }

    @Test
    public void testSelectNameAll(){
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<String> nameList = mapper.selectNameAll();
        for (String name:nameList)
            System.out.println("name = " + name);
    }

    //5返回自增的主键值
    @Test
    public void testInsertStudent(){
        Student stu=new Student();
        stu.setNumber("20230723066");
        stu.setName("方小宝");
        stu.setAge(19);
        stu.setIntro("无");
        System.out.println("stu.getId() = " + stu.getId());
        System.out.println("-------------------------------------");
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        mapper.insertStudent(stu);
        System.out.println("stu.getId() = " + stu.getId());
    }

    //6 如果表字段（id,xh,xm,nl,grjs）和类的属性(id,number,name,age,intro)不同名
    // 6.1 别名
    @Test
    public void testSelectOldAlias(){
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.selectOldAlias(3);
        System.out.println("student = " + student);
    }

    // 6.2 resultMap
    @Test
    public void testSelectOld(){
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.selectOld(4);
        System.out.println("student = " + student);
    }

}
