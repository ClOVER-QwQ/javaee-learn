package com.javaee.input.test;

import com.javaee.input.mapper.StudentMapper;
import com.javaee.input.po.Student;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MybatisTest2 {

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
    public void testUpdate(){
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        //1  杨清平  20
        mapper.update(1,"1",18);
    }

    //2.2 多个简单类型参数 @Param("自定义别名")
    @Test
    public void testUpdateByAlias(){
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        mapper.updateByAlias(1,"杨清平",20);
    }

    //2.3 多个简单类型参数 @Param("自定义别名")
    // 动态传入表名或列名时必须使用${}取值
    // #{}与${}区别，观察日志
    @Test
    public void testSelectByParam(){
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student1 = mapper.selectByParam("name", "李莲花");
        System.out.println("student1 = " + student1);
        Student student2 = mapper.selectByParam("id", 7);
        System.out.println("student2 = " + student2);
    }

    //2.4 扩展：${}导致安全隐患Sql注入攻击
    @Test
    public void testDeleteByNum(){
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        mapper.deleteByNum("345 or id>10");
    }

    //3 实体类型参数
    @Test
    public void testInsertStudent(){
        Student stu=new Student();
        stu.setNumber("22302091008");
        stu.setName("张梦云");
        stu.setAge(20);
        stu.setIntro("2022级软件工程1班学生");

        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        mapper.insertStudent(stu);
    }

    //4 Map类型参数
    @Test
    public void testUpdateByMap(){
        HashMap<String,Object> paramMap = new HashMap<>();
        paramMap.put("id",1);
        paramMap.put("name","方小宝");
        paramMap.put("age",18);
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        mapper.updateByMap(paramMap);
    }


}
