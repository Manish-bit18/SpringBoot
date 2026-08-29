package com.demo.filterdemo.controller;


import com.demo.filterdemo.dto.Student;
import com.demo.filterdemo.dto.StudentResponseDto;
import com.demo.filterdemo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<StudentResponseDto> createStudent(@RequestBody Student student) {
        StudentResponseDto responseDto =
                studentService.createStudent(student);
        return ResponseEntity.ok(responseDto);
    }
}