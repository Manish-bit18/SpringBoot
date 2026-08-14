package com.demo.employee_management.repository;

import com.demo.employee_management.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee , Long>{

    Optional<Employee> findByIdAndDeletedIsFalse(Long id);

    List<Employee> findByDeletedIsFalse();
}
