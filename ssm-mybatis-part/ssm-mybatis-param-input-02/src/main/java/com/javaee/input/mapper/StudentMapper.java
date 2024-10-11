package com.javaee.input.mapper;

import com.javaee.input.po.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.Map;

public interface StudentMapper {
    //1 单个简单类型参数  #{}
    Student selectById(int sid);

    //2.1 多个简单类型参数 [arg2,arg1,arg0  param3,param2,param1]
    int update(@Param("sid") int sid, @Param("sname") String sname,@Param("sage") int sage);

    //2.2 多个简单类型参数 @Param("自定义别名")
    int updateByAlias(@Param("sid")int sid,
                      @Param("sname")String sname,
                      @Param("sage")int sage);

    //2.3 多个简单类型参数 @Param("自定义别名")
    // 动态传入表名或列名时必须使用${}取值
    // #{}与${}区别，观察日志
    Student selectByParam(@Param("columnName")String columnName,
                          @Param("paramValue")Object paramValue);

    //2.4 扩展：${}导致安全隐患Sql注入攻击
    int deleteByNum(String snum);

    //3 实体类型参数
    int insertStudent(Student student);

    //4 Map类型参数
    int updateByMap(Map<String,Object> map);


}
