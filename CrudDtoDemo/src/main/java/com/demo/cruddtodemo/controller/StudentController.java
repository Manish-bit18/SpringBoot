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
    @PostMapping("/create")
    public ResponseEntity<StudentResponseDto> create(
           @Valid @RequestBody StudentRequestDto studentRespDto) {
        StudentResponseDto studentResponseDto = studentService.createStudent(studentRespDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                             .body(studentResponseDto);
    }

    @GetMapping("/get")
    public ResponseEntity<StudentResponseDto> getStudent(@RequestParam Long id){
        StudentResponseDto studentResp = studentService.getStudent(id);

        if(studentResp == null){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }

        return ResponseEntity.ok(studentResp);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<StudentResponseDto>> getAllStudent(){
        List<StudentResponseDto> studentList = studentService.getAllStudent();

        if(studentList.isEmpty()){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND) // ResponseEntity.notFound().build();
                    .body(studentList);
        }
        return ResponseEntity.ok(studentList);
    }

    @PutMapping("/update")
    public ResponseEntity<UpdateStudentResponseDto> updateStudent(@RequestParam Long id , @RequestBody UpdateStudentRequestDto studentReq){
        UpdateStudentResponseDto studentResp =
                studentService.updateStudent(id, studentReq);
        if(studentResp == null){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)    // Or ResponseEntity.notFound().build();
                    .body(null);
        }

        return ResponseEntity.ok(studentResp);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteStudent(@RequestParam Long id){
        boolean isDeleted = studentService.deleteStudent(id);

        if(!isDeleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok("Record Deleted");
    }
    //exists by id and Deleted = false

    @PatchMapping("/delete-soft")
    public ResponseEntity<String> deleteStudentSoftly(@RequestParam  Long id) {
        Boolean isDeleted = studentService.deleteStudentSoftly(id);

        if(!isDeleted){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok("Deleted Successfully");
    }

}
