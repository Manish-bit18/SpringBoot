package com.demo.jpa_relationshipdemo.repository;

import com.demo.jpa_relationshipdemo.entity.Department;
import com.demo.jpa_relationshipdemo.entity.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository
public class TeacherRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Teacher teacher) {
        entityManager.persist(teacher);
    }

}
