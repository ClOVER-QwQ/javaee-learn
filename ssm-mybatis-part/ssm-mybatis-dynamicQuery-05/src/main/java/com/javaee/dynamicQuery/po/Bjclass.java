package com.javaee.dynamicQuery.po;

import java.util.List;

// bjclass {bj_id,bj_code,bj_name}
public class Bjclass {
    private int bjId;
    private String bjCode;
    private String bjName;

    //对多：一个班级对应多个学生
    private List<Student> students;

    //set、get方法
    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getBjId() {
        return bjId;
    }

    public void setBjId(int bjId) {
        this.bjId = bjId;
    }

    public String getBjCode() {
        return bjCode;
    }

    public void setBjCode(String bjCode) {
        this.bjCode = bjCode;
    }

    public String getBjName() {
        return bjName;
    }

    public void setBjName(String bjName) {
        this.bjName = bjName;
    }

    @Override
    public String toString() {
        return "Bjclass{" +
                "bjId=" + bjId +
                ", bjCode='" + bjCode + '\'' +
                ", bjName='" + bjName + '\'' +
                '}';
    }
}
