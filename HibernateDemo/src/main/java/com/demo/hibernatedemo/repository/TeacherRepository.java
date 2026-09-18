package com.demo.hibernatedemo.repository;

import com.demo.hibernatedemo.entity.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeacherRepository {

    @PersistenceContext
    private EntityManager entityManager;


    public void createTeacher(Teacher teacher) {
        entityManager.persist(teacher);
    }

    public Teacher findTeacherById(Long id)  {
        return entityManager.find(Teacher.class, id);
    }

    public List<Teacher> findAllTeachers() {
        return entityManager
                .createQuery("SELECT t FROM Teacher t", Teacher.class)
                .getResultList();
    }

    public void deleteTeacher(Long id){
        entityManager.remove(entityManager.find(Teacher.class, id));
    }
}




//persist → INSERT
//find    → SELECT
//merge   → UPDATE
//remove  → DELETE