package com.demo.aop_demo2.service;

import com.demo.aop_demo2.annotation.TrackExecutionTime;
import com.demo.aop_demo2.dto.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @TrackExecutionTime(
            warnAfter = 2000,
            operation = "Creating New Student"
    )
    public Student createStudent(Student student) {
        System.out.println("Student saved");
        return student;
    }

    @TrackExecutionTime(
            warnAfter = 1500,
            operation = "Get Student Data"
    )
    public String getStudent(String s) {
        try {
            Thread.sleep(2000);
        }
        catch(Exception e) {}

        System.out.println(s);
        return s;
    }

    public int dummyMethod(String s) {
        return 0;
    }
}