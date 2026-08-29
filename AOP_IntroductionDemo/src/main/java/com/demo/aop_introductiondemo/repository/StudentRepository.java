package com.demo.aop_introductiondemo.repository;

import com.demo.aop_introductiondemo.dto.Student;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    public void save(Student student) {
        System.out.println("Student saved");

    }
}