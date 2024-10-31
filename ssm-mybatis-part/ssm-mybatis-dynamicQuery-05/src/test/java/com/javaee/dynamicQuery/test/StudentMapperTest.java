package com.javaee.dynamicQuery.test;

import com.javaee.dynamicQuery.mapper.StudentMapper;
import com.javaee.dynamicQuery.po.Bjclass;
import com.javaee.dynamicQuery.po.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    //1.1 <if>的使用
    //根据学号、姓名和年龄等多条件组合查询出符合条件的学生
    //List<Student> queryByMultiParam1(Student student);
    @Test
    public void testQueryByMultiParam1(){
        Student student1 = new Student();
//        student1.setNumber("02");
//        student1.setName("韦之鹏");
//        student1.setAge(30);
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.queryByMultiParam1(student1);
        for (Student student:students) {
            System.out.println("student = " + student);
        }
    }

    //1.2 <if>的使用,多表查询
    // 根据学号、姓名和班级编号等多条件组合查询出符合条件的学生
    //List<Student> queryByMultiParam2(Map<String,String> map);
    @Test
    public void testQueryByMultiParam2(){
        HashMap<String,String> map = new HashMap<>();
//        map.put("number","22302091001");
        map.put("name","韦之鹏");
        map.put("bjCode","22RG01");
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.queryByMultiParam2(map);
        for (Student student:students) {
            System.out.println("student = " + student);
        }
    }

    //2.1 <if>+<where>的使用
    // 根据学号、姓名和年龄等多条件组合查询出符合条件的学生
    //List<Student> queryByMultiParam3(Student student);
//    @Test
//    public void testQueryByMultiParam3(){
//        Student student1 = new Student();
//        student1.setNumber("91");
//        student1.setName("韦之鹏");
//        student1.setAge(20);
//        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
//        List<Student> students = mapper.queryByMultiParam3(student1);
//        for (Student student:students) {
//            System.out.println("student = " + student);
//        }
//    }
//
//    //2.2 根据id，只修改有值的列
//    //int updateStudent(Student stu);
//    @Test
//    public void testUpdateStudent(){
//        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
//        Student stu= new Student();
//        stu.setName("杨清平");
//        stu.setIntro("22软工1班学生");
//        stu.setId(51);
//        int row = mapper.updateStudent(stu);
//        System.out.println("row = " + row);
//        Student stu2= new Student();
//        stu2.setName("杨清平");
//        List<Student> students = mapper.queryByMultiParam1(stu2);
//        System.out.println("students.get(0) = " + students.get(0));
//    }
//
//    //3 <choose>、<when>、<otherwise>的使用
//    //List<Student> selectByOneCondition(Student stu);
//    @Test
//    public void testSelectByOneCondition(){
//        Student stu = new Student();
//        stu.setNumber("22302091001");
//        stu.setName("方小宝");
//        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
//        List<Student> students = mapper.selectByOneCondition(stu);
//        for (Student student:students) {
//            System.out.println("student = " + student);
//        }
//    }
//
//    //4.1 <foreach>的使用--批量删除
//    @Test
//    public void testDeleteMulti(){
//        int[] ids={90,92,94,96};
//        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
//        int deleteRows = mapper.deleteMulti(ids);
//        System.out.println("deleteRows = " + deleteRows);
//    }
//    @Test
//    public void testDeleteMulti2(){
//        int[] ids={90,92,94,96};
//        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
//        int deleteRows = mapper.deleteMulti2(ids);
//        System.out.println("deleteRows = " + deleteRows);
//    }
//
//    //4.2 <foreach>的使用--批量插入
//    //int insertStudents(List<Student> list);
//    @Test
//    public void testInsertStudents(){
//        List<Student> list = new ArrayList<>();
//        Student stu1 = new Student();
//        stu1.setNumber("20241001");
//        stu1.setName("雷无桀");
//        stu1.setAge(18);
//        stu1.setIntro("");
//        list.add(stu1);
//        Student stu2 = new Student();
//        stu2.setNumber("20241002");
//        stu2.setName("无心");
//        stu2.setAge(17);
//        stu2.setIntro("");
//        list.add(stu2);
//        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
//        int insertRows = mapper.insertStudents2(list);
//        System.out.println("insertRows = " + insertRows);
//        for (Student stu:list){
//            System.out.println("id="+stu.getId());
//        }
//    }

}
