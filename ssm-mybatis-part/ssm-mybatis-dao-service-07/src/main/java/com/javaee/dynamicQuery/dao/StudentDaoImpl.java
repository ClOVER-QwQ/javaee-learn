package com.javaee.dynamicQuery.dao;

import com.javaee.dynamicQuery.mapper.StudentMapper;
import com.javaee.dynamicQuery.po.Student;
import com.javaee.dynamicQuery.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;


public class StudentDaoImpl implements StudentDao{

    @Override
    public List<Student> queryByMultiParam1(Student student) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.queryByMultiParam1(student);
        sqlSession.close();
        return students;
    }
}
