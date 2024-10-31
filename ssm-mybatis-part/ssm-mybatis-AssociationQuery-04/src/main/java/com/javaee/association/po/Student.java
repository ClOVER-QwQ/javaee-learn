package com.javaee.association.po;

//student(id,number,name,age,intro,bj_id)
public class Student {
    private int id;
    private String number;
    private String name;
    private int age;
    private String intro;

    //对一：归属一个班级
    private Bjclass bjclass;

    //set、get方法
    public Bjclass getBjclass() {
        return bjclass;
    }

    public void setBjclass(Bjclass bjclass) {
        this.bjclass = bjclass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }


    public String toString() {
        return "Student{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", intro='" + intro + '\'' +
                '}';
    }
}
