package com.demo.jpa_relationshipdemo.repository;

import com.demo.jpa_relationshipdemo.entity.Department;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Department department) {
        entityManager.persist(department);
    }

    public Department getDepartmentById(Long id) {
        return entityManager.find(Department.class, id);
    }
}
