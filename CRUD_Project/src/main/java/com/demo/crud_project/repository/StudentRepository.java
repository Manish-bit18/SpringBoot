package com.demo.crud_project.repository;

import com.demo.crud_project.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

//@Repository  //Managed by JPA
public interface StudentRepository extends JpaRepository<Student , Long>{

}
