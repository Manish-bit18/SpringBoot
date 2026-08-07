package com.demo.crud_project.controller;

import com.demo.crud_project.entity.Student;
import com.demo.crud_project.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student createdStudent = studentService.createStudent(student);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdStudent);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id){
        Student studentResp = studentService.getStudent(id);

        if(studentResp == null){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }

        return ResponseEntity.ok(studentResp);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAllStudent(){
        List<Student> studentList = studentService.getAllStudent();

        if(studentList.isEmpty()){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND) // ResponseEntity.notFound().build();
                    .body(studentList);
        }
        return ResponseEntity.ok(studentList);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id , @RequestBody Student studentReq){
        Student studentResp = studentService.updateStudent(id , studentReq);

        if(studentResp == null){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)    // Or ResponseEntity.notFound().build();
                    .body(null);
        }

        return ResponseEntity.ok(studentResp);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
        Boolean isDeleted = studentService.deleteStudent(id);

        if(!isDeleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok("Record Deleted");
    }

}
