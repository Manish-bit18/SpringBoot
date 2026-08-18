package com.demo.service;

import com.demo.entity.Student;
import com.demo.respository.StudentRespository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRespository studentRespository;

    public StudentService(StudentRespository studentRespository){
        this.studentRespository = studentRespository;
    }

    public Student createStudent(Student studentReq){
        return studentRespository.save(studentReq);
    }

    public Student getStudent(Long id){
        return studentRespository.findByID(id);
    }

    public List<Student> getAllStudent(){
        return studentRespository.findAll();
    }
}
