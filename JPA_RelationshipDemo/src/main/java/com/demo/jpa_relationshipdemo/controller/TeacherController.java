package com.demo.jpa_relationshipdemo.controller;


import com.demo.jpa_relationshipdemo.entity.Department;
import com.demo.jpa_relationshipdemo.entity.Teacher;
import com.demo.jpa_relationshipdemo.service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {

    private TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping("/{deptId}")
    public ResponseEntity<String> createTeacher(
            @RequestBody Teacher teacher,
            @PathVariable Long deptId)  {

        teacherService.createTeacher(teacher ,deptId);

        return ResponseEntity.ok("Created");

    }
}
