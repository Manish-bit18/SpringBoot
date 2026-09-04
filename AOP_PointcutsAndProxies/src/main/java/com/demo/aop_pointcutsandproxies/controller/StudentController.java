package com.demo.aop_pointcutsandproxies.controller;


import com.demo.aop_pointcutsandproxies.dto.Student;
import com.demo.aop_pointcutsandproxies.service.StudentServiceInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentServiceInterface studentService;

    public StudentController(StudentServiceInterface studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student s = studentService.createStudent(student);
        return ResponseEntity.ok(s);
    }

    @GetMapping
    public ResponseEntity<String> getStudenet() {
        String s = "All Student Data";
        return ResponseEntity.ok(studentService.getStudent(s));
    }
}