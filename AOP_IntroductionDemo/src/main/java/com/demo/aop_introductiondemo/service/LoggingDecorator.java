package com.demo.aop_introductiondemo.service;

import com.demo.aop_introductiondemo.dto.Student;
import org.springframework.stereotype.Component;

@Component
public class LoggingDecorator implements StudentService {

    private StudentServiceImpl studentServiceimpl;

    public LoggingDecorator(StudentServiceImpl studentServiceimpl) {
        this.studentServiceimpl = studentServiceimpl;
    }

    @Override
    public void createStudent(Student student) {
        // Logging realted logic

        LoggingServiceUtil.logStart(
                "StudentServiceImpl", "createStudent");

        studentServiceimpl.createStudent(student);

        LoggingServiceUtil.logEnd(
                "StudentServiceImpl", "createStudent");
    }


}