package com.demo.jpa_relationshipdemo.service;

import com.demo.jpa_relationshipdemo.entity.Department;
import com.demo.jpa_relationshipdemo.entity.Teacher;
import com.demo.jpa_relationshipdemo.repository.DepartmentRepository;
import com.demo.jpa_relationshipdemo.repository.TeacherRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {


    private DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Transactional
    public void createTeacher(Department department){
        departmentRepository.save(department);
    }
}
