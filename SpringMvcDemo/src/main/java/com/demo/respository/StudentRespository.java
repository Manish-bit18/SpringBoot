package com.demo.respository;

import com.demo.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRespository {

    private Map<Long, Student> studentDB;

    public StudentRespository() {
        studentDB = new HashMap<>();
    }

    public Student save(Student studentReq) {
        studentDB.put((long) studentReq.getId(), studentReq);
        return studentReq;
    }

    public Student findByID(Long id) {
        return studentDB.get(id);
    }

    public List<Student> findAll() {
        return new ArrayList<>(studentDB.values());
    }
}