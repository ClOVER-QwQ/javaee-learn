package com.javaee;

import com.javaee.annotaion.SpringConfig;
import com.javaee.annotaion.po.Student;
import com.javaee.annotaion.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//任务1.2：完善测试类验证
public class SpringConfigClassTest {
    private Student stu;
    @BeforeEach
    public void before(){
        stu=new Student(); //测试数据
        stu.setNum("22302091010");
        stu.setName("徐杰");
        stu.setAge(20);
        stu.setIntro("2022级软件工程1班学生");
    }

    @Test
    public void testSpringAnnotaionConfig04() {
        //1 根据SpringConfig类创建spring容器
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        //2 从spring容器中获取bean
        StudentService studentService = context.getBean(StudentService.class);
        studentService.addStudent(stu);
    }
}
