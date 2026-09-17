package com.demo.springjdbcdemo.controller;

import com.demo.springjdbcdemo.dto.Teacher;
import com.demo.springjdbcdemo.service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {

    private TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

        @PostMapping
        public ResponseEntity<String> createTeacher(@RequestBody Teacher teacher) {
            teacherService.createTeacher(teacher);
            return ResponseEntity.ok("DONE");
        }

        @GetMapping
        public ResponseEntity<List<Teacher>> getAllTeachers() {
            List<Teacher> teachers = teacherService.getAllTeachers();
            return ResponseEntity.ok(teachers);
        }

        @GetMapping("/{id}")
        public ResponseEntity<Teacher> getTeacherById(@PathVariable int id) {
            Teacher teacher = teacherService.getTeacherById(id);
            return ResponseEntity.ok(teacher);
        }

        @PutMapping
        public ResponseEntity<String> updateTeacher(@RequestBody Teacher teacher) {
            teacherService.updateTeacher(teacher);
            return ResponseEntity.ok("DONE");
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<String> deleteTeacher(@PathVariable int id) {
            teacherService.deleteTeacher(id);
            return ResponseEntity.ok("DONE");
        }
}

