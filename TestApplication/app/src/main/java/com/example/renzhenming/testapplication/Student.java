package com.example.renzhenming.testapplication;

import java.util.List;

/**
 * Created by renzhenming on 2017/6/20.
 */

public class Student {

    //fsdafasdfsadfsfsadfsd
    //dsfadfsafsdafsadf

    public Student(String name) {
        this.name = name;
    }

    public String name;
    public String sex;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public List<Course> courses;

    public class Course{
        public Course(String name) {
            this.name = name;
        }

        public String name;
    }
}
