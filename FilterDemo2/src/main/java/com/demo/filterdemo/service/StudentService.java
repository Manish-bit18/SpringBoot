package com.demo.filterdemo.service;


import com.demo.filterdemo.dto.Student;
import com.demo.filterdemo.dto.StudentResponseDto;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public StudentResponseDto createStudent(Student student) {
        StudentResponseDto responseDto = new StudentResponseDto();
        responseDto.setName(student.getName());
        responseDto.setMessage("Student is saved successfully");

        return responseDto;
    }
}