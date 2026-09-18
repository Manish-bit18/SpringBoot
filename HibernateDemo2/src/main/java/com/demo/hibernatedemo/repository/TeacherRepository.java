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

    public void saveAll(List<Teacher> teachers){
        int counter = 0;

        for(Teacher teacher : teachers){
            entityManager.persist(teacher);
            counter++;

            if(counter % 100 == 0){
                entityManager.flush();      //Sync with the database
                entityManager.clear();       // Remove from the peersitence Context so that persistence context doesnt become full

                //entityManager.refresh(teacher); // if Directly changes made in the database auto sync in persitence Context
            }
        }
    }


    public Teacher findTeacherById(Long id)  {
        Teacher t1 = entityManager.find(Teacher.class, id);

        // entityManager.contains(t1);
        return t1;
    }

    public List<Teacher> findAllTeachers() {
        return entityManager
                .createQuery("SELECT t FROM Teacher t", Teacher.class)
                .getResultList();
    }

    public void deleteTeacher(Long id){
        entityManager.remove(entityManager.find(Teacher.class, id));
    }

    public void detach(Teacher teacher) {
        entityManager.detach(teacher);
    }

    public void attachAgain(Teacher teacher) {
        entityManager.merge(teacher);
    }

    public void flush(){
        entityManager.flush();
    }
}




//persist → INSERT
//find    → SELECT
//merge   → UPDATE
//remove  → DELETE