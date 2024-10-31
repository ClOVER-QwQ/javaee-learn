package com.javaee.spring01.test;

import com.javaee.dao.StudentDao;
import com.javaee.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
    @Test
    public void testSpringIoc(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "spring01.xml");
          //通过bean的id获取bean对象时，需要强制类型转换
        StudentDao stuDao1 = (StudentDao)ctx.getBean("stuDao1");
        System.out.println("stuDao1 = " + stuDao1);
//        StudentDao stuDao3 = (StudentDao)ctx.getBean("stuDao3");
//        System.out.println("stuDao3 = " + stuDao3);

          //通过bean的class获取bean对象时，不需要强制类型转换
          // 但要求配置文件只配了一个StudentService的bean，
          // 否则抛出异常：NoUniqueBeanDefinitionException
        StudentService stuService = ctx.getBean(StudentService.class);
        stuService.addStudent();

        //通过bean的class获取bean对象时，不需要强制类型转换
        //但当配置文件配了多个StudentService的bean，可以传入id，明确访问哪个bean
        StudentService stuService2 = ctx.getBean("stuService2",StudentService.class);
        stuService2.addStudent();
    }

}
