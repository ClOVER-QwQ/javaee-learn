package com.clover.test;

import com.clover.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest {
    @Test
    public void testSelectById() throws IOException {
        //1.创建SqlSessionFactory对象
        InputStream resourceAsStream = Resources.getResourceAsStream("com/clover/config/mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        //2.通过sessionFactory对象开启一个SqlSession对象
        SqlSession sqlSession = sessionFactory.openSession();

        //3.通过sqlSession获取mapper接口的代理对象
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        //4.调用接口代理对象去执行数据库操作
        System.out.println(mapper.selectById(1));

        //5.关闭

        sqlSession.close();
    }

}
