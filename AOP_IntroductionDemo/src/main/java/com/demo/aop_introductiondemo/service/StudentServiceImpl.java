package com.demo.aop_introductiondemo.service;

import com.demo.aop_introductiondemo.dto.Student;
import com.demo.aop_introductiondemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void createStudent(Student student){
      studentRepository.save(student);
    }
}
