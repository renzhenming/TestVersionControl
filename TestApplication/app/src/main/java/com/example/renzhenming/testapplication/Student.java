package com.example.renzhenming.testapplication;

import java.util.List;

/**
 * Created by renzhenming on 2017/6/20.
 */

public class Student {

    public Student(String name) {
        this.name = name;
    }

    public String name;
    public List<Course> courses;

    public class Course{
        public Course(String name) {
            this.name = name;
        }

        public String name;
    }
}
