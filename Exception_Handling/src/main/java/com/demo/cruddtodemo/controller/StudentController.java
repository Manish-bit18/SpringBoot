package com.demo.cruddtodemo.controller;


import com.demo.cruddtodemo.dto.StudentRequestDto;

import com.demo.cruddtodemo.dto.StudentResponseDto;
import com.demo.cruddtodemo.dto.UpdateStudentRequestDto;
import com.demo.cruddtodemo.dto.UpdateStudentResponseDto;
import com.demo.cruddtodemo.entity.Student;
import com.demo.cruddtodemo.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private StudentService studentService;

    //"When creating a StudentController object, I expect a StudentService object as input."
    public  StudentController(StudentService studentService) {
        this.studentService  = studentService;

    }

    @PostMapping
    public ResponseEntity<StudentResponseDto> createStudent(
           @Valid @RequestBody StudentRequestDto studentRespDto) {
        StudentResponseDto studentResponseDto = studentService.createStudent(studentRespDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                             .body(studentResponseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDto> getStudent(@PathVariable Long id){
        StudentResponseDto studentResp = studentService.getStudent(id);

        return ResponseEntity.ok(studentResp);
    }

    @GetMapping
    public ResponseEntity<List<StudentResponseDto>> getAllStudent(){
        List<StudentResponseDto> studentList = studentService.getAllStudent();

        return ResponseEntity.ok(studentList);
    }

    @PutMapping
    public ResponseEntity<UpdateStudentResponseDto> updateStudent(
            @RequestParam Long id ,
            @RequestBody UpdateStudentRequestDto studentReq){

        UpdateStudentResponseDto studentResp =
                studentService.updateStudent(id, studentReq);

        return ResponseEntity.ok(studentResp);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteStudent(@RequestParam Long id){
        studentService.deleteStudent(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PatchMapping("/delete-soft")
    public ResponseEntity<String> deleteStudentSoftly(@RequestParam  Long id) {
        studentService.deleteStudentSoftly(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();    }

}
