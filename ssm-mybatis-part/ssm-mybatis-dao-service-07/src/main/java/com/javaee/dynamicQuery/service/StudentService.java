package com.javaee.dynamicQuery.service;

import com.javaee.dynamicQuery.po.Student;

import java.util.List;

public interface StudentService {
    List<Student> queryByMultiParam1(Student student);
}
