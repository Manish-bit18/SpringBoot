package com.demo.crud_project.service;


import com.demo.crud_project.entity.Student;
import com.demo.crud_project.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service   //Speciallized Annotation
public class StudentService {



    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student studentReq) {
        Student studentResp = studentRepository.save(studentReq);
        return studentResp;
    }

    public Student getStudent(Long id){
        Optional<Student> studentResp =  studentRepository.findById(id);
        //a value may or may not be present
        //isPresent() → Checks if a value exists.
        //get() → Retrieves the value.
        if(studentResp.isPresent()){
           return studentResp.get();
        }
        return null;
    }

    public List<Student> getAllStudent(){
       List<Student> studentList = studentRepository.findAll();
       return studentList;
    }

    public Student updateStudent(Long id ,
                                 Student studentReq) {
        Optional<Student> existingStudent  =  studentRepository.findById(id);

        if(existingStudent.isEmpty()){
            return null;
        }

        Student studentToSave = existingStudent.get();

        studentToSave.setName(studentReq.getName());
        studentToSave.setAge(studentReq.getAge());
        studentToSave.setRoll_no(studentReq.getRoll_no());
        studentToSave.setEmail(studentReq.getEmail());
        studentToSave.setSubject(studentReq.getSubject());

        return studentRepository.save(studentToSave);

    }

    public Boolean deleteStudent(Long id){
        Boolean isStudent = studentRepository.existsById(id);

        if(!isStudent) return false;
        studentRepository.deleteById(id);

        return true;
    }

    //1 .End Point Listen(/api/students)

    //2.Business Logic

    //3.Interact with DB to store

    //4.Response back to client
}
