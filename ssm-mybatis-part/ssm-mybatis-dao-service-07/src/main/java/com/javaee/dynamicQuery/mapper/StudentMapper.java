package com.javaee.dynamicQuery.mapper;

import com.javaee.dynamicQuery.po.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

//接口代码待补充
public interface StudentMapper {

    //1.1 <if>的使用
    //根据学号、姓名和年龄等多条件组合查询出符合条件的学生
    List<Student> queryByMultiParam1(Student student);

    //1.2 <if>的使用,多表查询
    // 根据学号、姓名和班级编号等多条件组合查询出符合条件的学生
    List<Student> queryByMultiParam2(Map<String,Object> map);

//    List<Student> queryByMultiParam2(@Param("number") String number,
//                                     @Param("name")String name,
//                                     @Param("bjCode")String bjCode);

    //2.1 <where>配合<if>的使用
    // 根据学号、姓名和年龄等多条件组合查询出符合条件的学生
    List<Student> queryByMultiParam3(Student student);

    //2.2 <set>配合<if>的使用
    // 根据id，只修改有值的列
    int updateStudent();

    //3 <choose>、<when>、<otherwise>的使用
    // 多条件按优先级查询，
    // 如果有学号则按照学号，
    // 没有学号，有姓名则按照姓名查询
    // 否则查询age>30
     List<Student> selectByOneCondition(Student student);

    //4.1 <foreach>的使用--批量删除
    /*
    Cause: org.apache.ibatis.binding.BindingException:
    Parameter 'ids' not found. Available parameters are [array, arg0]
     */
    int deleteMulti(int[] ids);

    int deleteMulti2(@Param("ids") int[] ids);


    //4.2 <foreach>的使用--批量插入
    int insertStudents(List<Student> studentList);
    int insertStudents2(@Param("studentList") List<Student> studentList);
}
