package com.javaee.annotaion.service.Impl;
import com.javaee.annotaion.dao.Impl.StudentDaoImpl02;
import com.javaee.annotaion.po.Student;
import com.javaee.annotaion.dao.StudentDao;
import com.javaee.annotaion.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("stuService")
public class StudentServiceImpl implements StudentService {

    /*使用@Autowired依赖注入，默认按照类型注入；
      当有多个同类型的bean时，需要@Qualifier指定bean的名字（id）*/

    @Autowired
    @Qualifier("stuDao2")
    private StudentDao studentDao;

    public int addStudent(Student student){
        int rowCount=0;
        if(studentDao.selectByNum(student.getNum())<1){
            rowCount = studentDao.insertStudent(student);
            System.out.println("成功保存");
        }else{
            System.out.println("数据库已存在该学号！");
        }
        return rowCount;
    }
}

    /* 创建Spring容器时会扫描注解，创建bean，并完成bean之间的依赖注入（装配）
    org.springframework.beans.factory.UnsatisfiedDependencyException:
    Error creating bean with name 'stuService':
    Unsatisfied dependency expressed through field 'studentDao':
    No qualifying bean of type 'com.javaee.annotaion.dao.StudentDao' available:
    expected single matching bean but found 2: stuDao,stuDaoOracle
    @Autowired
    private StudentDao studentDao;
     */