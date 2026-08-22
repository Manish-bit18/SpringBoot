package com.demo.cruddtodemo.repository;

import com.demo.cruddtodemo.dto.StudentResponseDto;
import com.demo.cruddtodemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

//@Repository  //Managed by JPA
public interface StudentRepository extends JpaRepository<Student , Long> {

    Optional<Student> findByIdAndDeletedIsFalse(Long id);  // JPA will do it by there own

    List<Student> findByDeletedIsFalse();  //JPA will make the custom Query by its Own and will manage it

    //findBy + fieldName + condition;
}

