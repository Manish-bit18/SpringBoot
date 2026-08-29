package com.demo.aop_introductiondemo.controller;


import com.demo.aop_introductiondemo.dto.Student;
import com.demo.aop_introductiondemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentController {


    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<String> addStudent(@RequestBody Student student) {
        studentService.createStudent(student);
        return ResponseEntity.ok("Added Successfully");
    }
}
