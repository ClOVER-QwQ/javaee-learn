package com.javaee.output.mapper;

import com.javaee.output.po.Student;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

public interface StudentMapper {

    //0 DML操作不需要指定,自动返回操作影响的行数
    int deleteById(int sid);

    //1 返回单个简单类型
    //扩展： mybatis内部别名
    int selectStudentCount();
    String selectNameById(int sid);

    //2 返回实体类对象
    //扩展：自定义别名
    Student selectById(int sid);

    //3 返回Map类型
    @MapKey("id")
    Map<String,Integer> selectAgeCount(int age);

    //4 返回List类型
    List<Student> selectAll();
    List<String> selectNameAll();

    //5返回自增的主键值
    int insertStudent(Student student);

    //6 如果表字段（id,xh,xm,nl,grjs）和类的属性(id,number,name,age,intro)不同名
    // 6.1 别名
    Student selectOldAlias(int sid);

    // 6.2 resultMap
    Student selectOld(int sid);
}
