package com.demo.cruddtodemo.service;

import com.demo.cruddtodemo.dto.StudentRequestDto;
import com.demo.cruddtodemo.dto.StudentResponseDto;
import com.demo.cruddtodemo.dto.UpdateStudentRequestDto;
import com.demo.cruddtodemo.dto.UpdateStudentResponseDto;
import com.demo.cruddtodemo.entity.Student;
import com.demo.cruddtodemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public StudentResponseDto createStudent(StudentRequestDto studentReqDto){
        Student student = mapToEntity(studentReqDto);
        Student studentResp = studentRepository.save(student);
        return mapToDto(studentResp);
    }

    public StudentResponseDto getStudent(Long id){
        Optional<Student> studentResp =  studentRepository.findByIdAndDeletedIsFalse(id);
        //a value may or may not be present
        //isPresent() → Checks if a value exists.
        //get() → Retrieves the value.
        if(studentResp.isPresent()){
            return mapToDto(studentResp.get());
        }
        return null;
    }
    //Select * from student where id = 1 and deleted = false means which are not earlier deleted
    //findByIdAndDeletedIsFalse

    public List<StudentResponseDto> getAllStudent(){
        List<Student> studentList = studentRepository.findByDeletedIsFalse();
        List<StudentResponseDto> studentResponseDtos = new ArrayList<>();
        for(Student student : studentList){
             studentResponseDtos.add(mapToDto(student));
        }
        return studentResponseDtos;
    }
    //Select * from student where deleted = false
    //findAllAndDeletedIsFalse

    public UpdateStudentResponseDto updateStudent(Long id ,
                                                  UpdateStudentRequestDto studentReq) {
        Optional<Student> existingStudent  =  studentRepository.findByIdAndDeletedIsFalse(id);

        if(existingStudent.isEmpty()){
            return null;
        }

        Student studentToSave = existingStudent.get();


        studentToSave.setName(studentReq.getName());
        studentToSave.setAge(studentReq.getAge());
        studentToSave.setRoll_no(studentReq.getRoll_no());
        studentToSave.setSubject(studentReq.getSubject());

        Student savedStudent = studentRepository.save(studentToSave);

        return mapToUpdateDto(savedStudent);

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


    private Student mapToEntity(StudentRequestDto studentReqDto){
        Student student = new Student();

        student.setName(studentReqDto.getName());
        student.setAge(studentReqDto.getAge());
        student.setEmail(studentReqDto.getEmail());
        student.setRoll_no(studentReqDto.getRoll_no());
        student.setSubject(studentReqDto.getSubject());
        student.setDeleted(false);
        return student;
    }

    private StudentResponseDto mapToDto(Student student){
        StudentResponseDto studentResp = new StudentResponseDto();

        studentResp.setId(student.getId());
        studentResp.setName(student.getName());
        studentResp.setAge(student.getAge());
        studentResp.setEmail(student.getEmail());
        studentResp.setRoll_no(student.getRoll_no());
        studentResp.setSubject(student.getSubject());
        studentResp.setMessage("Student created successfully");
        studentResp.setCreated_at(LocalDateTime.now());
        studentResp.setUpdated_at(LocalDateTime.now());
        return studentResp;
    }

    private UpdateStudentResponseDto mapToUpdateDto(Student student) {
        UpdateStudentResponseDto responseDto = new UpdateStudentResponseDto();

        responseDto.setId(student.getId());
        responseDto.setName(student.getName());
        responseDto.setAge(student.getAge());
        responseDto.setEmail(student.getEmail());
        responseDto.setRoll_no(student.getRoll_no());
        responseDto.setSubject(student.getSubject());
        responseDto.setMessage("Student updated successfully");
        responseDto.setUpdated_at(student.getUpdated_at());

        return responseDto;
    }

}
