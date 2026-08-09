package com.demo.soft_delete.service;


import com.demo.soft_delete.entity.Student;
import com.demo.soft_delete.repository.StudentRepository;
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
        studentReq.setDeleted(false);  // Every created will be as not deleted;
        Student studentResp = studentRepository.save(studentReq);
        return studentResp;
    }

    public Student getStudent(Long id){
        Optional<Student> studentResp =  studentRepository.findByIdAndDeletedIsFalse(id);
        //a value may or may not be present
        //isPresent() → Checks if a value exists.
        //get() → Retrieves the value.
        if(studentResp.isPresent()){
           return studentResp.get();
        }
        return null;
    }
    //Select * from student where id = 1 and deleted = false means which are not earlier deleted
    //findByIdAndDeletedIsFalse

    public List<Student> getAllStudent(){
       List<Student> studentList = studentRepository.findByDeletedIsFalse();
       return studentList;
    }
    //Select * from student where deleted = false
    //findAllAndDeletedIsFalse

    public Student updateStudent(Long id ,
                                 Student studentReq) {
        Optional<Student> existingStudent  =  studentRepository.findByIdAndDeletedIsFalse(id);

        if(existingStudent.isEmpty()){
            return null;
        }

        Student studentToSave = existingStudent.get();

        studentToSave.setName(studentReq.getName());
        studentToSave.setAge(studentReq.getAge());
        studentToSave.setRoll_no(studentReq.getRoll_no());
        studentToSave.setEmail(studentReq.getEmail());
        studentToSave.setSubject(studentReq.getSubject());
        studentToSave.setDeleted(false);

        return studentRepository.save(studentToSave);

    }

    public Boolean deleteStudent(Long id){
        Boolean isStudent = studentRepository.existsById(id);

        if(!isStudent) return false;
        studentRepository.deleteById(id);

        return true;
    }


    public Boolean deleteStudentSoftly(Long id){
        Optional<Student> existingStudent = studentRepository.findByIdAndDeletedIsFalse(id);

        if(existingStudent.isEmpty()){
            return false;
        }

        Student studentToSave = existingStudent.get();

        studentToSave.setDeleted(true);

        studentRepository.save(studentToSave);

        return true;
    }


    //1 .End Point Listen(/api/students)

    //2.Business Logic

    //3.Interact with DB to store

    //4.Response back to client
}
