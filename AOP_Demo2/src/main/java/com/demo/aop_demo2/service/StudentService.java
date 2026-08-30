package com.demo.aop_demo2.service;

import com.demo.aop_demo2.dto.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {


    public Student createStudent(Student student) {
        System.out.println("Student saved");
        //throw new RuntimeException("Some error happened");
        return student;
    }

    public String dummyMethod(String s) {
        System.out.println("dummyMethod called");
        return s;
    }
}
