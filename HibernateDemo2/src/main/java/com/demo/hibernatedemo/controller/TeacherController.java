package com.demo.hibernatedemo.controller;

import com.demo.hibernatedemo.entity.Teacher;
import com.demo.hibernatedemo.service.TeacherService;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    private TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping
    public ResponseEntity<String> createTeacher(@RequestBody Teacher teacher)  {
        teacherService.createTeacher(teacher);
        return ResponseEntity.ok("Done");

    }

    @GetMapping
    public ResponseEntity<List<Teacher>> getAllTeachers(){
        List<Teacher> teachers = teacherService.getAllTeacher();
        return ResponseEntity.ok(teachers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Teacher> getTeacher(@PathVariable Long id)  {
        Teacher teacher = teacherService.getTeacherById(id);
        return ResponseEntity.ok(teacher);
    }

    @PutMapping
    public ResponseEntity<String> updateTeacher(@RequestBody Teacher teacher){
        teacherService.updateTeacher(teacher);
        return ResponseEntity.ok("Done");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTeacher(@PathVariable Long id)  {
        teacherService.deleteTeacher(id);
        return ResponseEntity.ok("Done");
    }
}
