package com.demo.hibernatedemo.service;

import com.demo.hibernatedemo.entity.Teacher;
import com.demo.hibernatedemo.repository.TeacherRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class TeacherService {

    private TeacherRepository  teacherRepository;


    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Transactional
    public void createTeacher(Teacher teacher)  {
        teacherRepository.createTeacher(teacher);
    }

    public List<Teacher> getAllTeacher(){
       List<Teacher> teachers = teacherRepository.findAllTeachers();
        return teachers;
    }


    public Teacher getTeacherById(Long id){
        return teacherRepository.findTeacherById(id);
    }

    @Transactional
    public Teacher updateTeacher(Teacher teacher)  {
        Teacher teacher1 = teacherRepository.findTeacherById(teacher.getId());

        teacherRepository.detach(teacher1);

       // teacherRepository.attachAgain(teacher);

        teacher1.setName(teacher.getName());
        teacher1.setAge(teacher.getAge());
        teacher1.setEmail(teacher.getEmail());

        return teacher1;

    }

    @Transactional
    public void deleteTeacher(Long id) {
        teacherRepository.deleteTeacher(id);
    }
}
