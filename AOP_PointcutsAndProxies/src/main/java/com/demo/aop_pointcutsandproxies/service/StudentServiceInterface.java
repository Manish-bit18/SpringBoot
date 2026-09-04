package com.demo.aop_pointcutsandproxies.service;


import com.demo.aop_pointcutsandproxies.dto.Student;

public interface StudentServiceInterface {

    Student createStudent(Student student);

    String getStudent(String s);
}