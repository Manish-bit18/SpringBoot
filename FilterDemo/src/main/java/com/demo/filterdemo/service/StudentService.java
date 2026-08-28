package com.demo.filterdemo.service;

import com.demo.filterdemo.dto.Student;
import org.springframework.stereotype.Service;

@Service
public  class StudentService {

    public Student createStudent(Student student){

            System.out.println("Student Created");
            System.out.println(student.getName());
            System.out.println(student.getEmail());
            return student;
    }

}
