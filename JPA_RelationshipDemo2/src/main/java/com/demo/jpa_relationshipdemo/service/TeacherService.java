package com.demo.jpa_relationshipdemo.service;

import com.demo.jpa_relationshipdemo.entity.Department;
import com.demo.jpa_relationshipdemo.entity.Teacher;
import com.demo.jpa_relationshipdemo.repository.DepartmentRepository;
import com.demo.jpa_relationshipdemo.repository.TeacherRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    private TeacherRepository teacherRepository;

    private DepartmentRepository departmentRepository;

    public TeacherService(TeacherRepository teacherRepository , DepartmentRepository departmentRepository) {
        this.teacherRepository = teacherRepository;
        this.departmentRepository = departmentRepository;
    }

    @Transactional
    public void createTeacher(Teacher teacher, Long deptId){

        Department department = departmentRepository.getDepartmentById(deptId);

        teacher.setDepartment(department);

        teacherRepository.save(teacher);
    }
}
