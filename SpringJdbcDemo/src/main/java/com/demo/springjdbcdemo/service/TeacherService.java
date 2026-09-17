package com.demo.springjdbcdemo.service;

import com.demo.springjdbcdemo.dto.Teacher;
import org.springframework.stereotype.Service;
import com.demo.springjdbcdemo.repository.TeacherRepository;

import java.util.List;

@Service
public class TeacherService {

    private TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public void createTeacher(Teacher teacher) {
        teacherRepository.createTeacher(teacher);
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepository.getTeacher();
    }

    public Teacher getTeacherById(int id) {
        return teacherRepository.getTeacherById(id);
    }

    public void updateTeacher(Teacher teacher ) {
        teacherRepository.updateTeacher(teacher, teacher.getId());
    }

    public void deleteTeacher(int id) {
        teacherRepository.deleteTeacher(id);
    }
}