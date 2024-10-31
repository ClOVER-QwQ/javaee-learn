package com.javaee.annotation.test;

import com.javaee.annotaion.po.Student;
import com.javaee.annotaion.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAnnotationTest {
    private Student stu;

    @BeforeEach
    public void before(){
        stu=new Student(); //测试数据
        stu.setNum("22302091099");
        stu.setName("徐杰东");
        stu.setAge(20);
        stu.setIntro("2022级软件工程1班学生");
    }

    /*执行该类时需要先把StudentDaoImpl02类的@Repository("stuDao2")去掉
    * 因为StudentDaoImpl02依赖注入jdbcTemplate，但spring01.xml没有管理jdbcTemplate*/
    @Test
    public void testSpringAnnotaionXml01() {
        //1 根据spring02.xml配置文件创建spring容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                                        "spring01.xml");
         //2 从spring容器中获取bean
        StudentService studentService = ctx.getBean(StudentService.class);
        studentService.addStudent(stu);
    }

    @Test
    public void testSpringAnnotaionXml02() {
        //1 根据spring02.xml配置文件创建spring容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                                     "spring02.xml");
        //2 从spring容器中获取bean
        StudentService studentService = ctx.getBean(StudentService.class);
        studentService.addStudent(stu);
    }

    @Test
    public void testSpringAnnotaionXml03() {
        //1 根据spring02.xml配置文件创建spring容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                                   "spring03.xml");
        //2 从spring容器中获取bean
        StudentService studentService = ctx.getBean(StudentService.class);
        studentService.addStudent(stu);
    }
}
