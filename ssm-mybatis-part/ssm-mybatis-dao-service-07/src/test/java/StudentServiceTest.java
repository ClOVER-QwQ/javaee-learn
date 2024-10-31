import com.javaee.dynamicQuery.mapper.StudentMapper;
import com.javaee.dynamicQuery.po.Student;
import com.javaee.dynamicQuery.service.StudentService;
import com.javaee.dynamicQuery.service.StudentServiceImpl;
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

public class StudentServiceTest {

    @Test
    public void testQueryByMultiParam1(){
        Student student1 = new Student();
        student1.setNumber("02");
        student1.setName("韦之鹏");
        student1.setAge(30);
        StudentService studentService = new StudentServiceImpl();
        List<Student> students = studentService.queryByMultiParam1(student1);
        for (Student student:students) {
            System.out.println("student = " + student);
        }
    }
}
