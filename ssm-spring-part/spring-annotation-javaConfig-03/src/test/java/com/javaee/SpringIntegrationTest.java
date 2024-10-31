package com.javaee;

import com.javaee.annotaion.SpringConfig;
import com.javaee.annotaion.po.Student;
import com.javaee.annotaion.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

//任务2：使用spring-test测试
@SpringJUnitConfig(value = {SpringConfig.class})
public class SpringIntegrationTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void testAddStudent(){
        studentService.addStudent(stu);
    }

    private Student stu;
    @BeforeEach
    public void before(){
        stu=new Student(); //测试数据
        stu.setNum("22302091010");
        stu.setName("徐杰");
        stu.setAge(20);
        stu.setIntro("2022级软件工程1班学生");
    }
}
