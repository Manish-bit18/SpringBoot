package com.demo.employee_management.service;

import com.demo.employee_management.entity.Employee;
import com.demo.employee_management.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employeeDetails){
         employeeDetails.setDeleted(false);
          Employee savedEmployee = employeeRepository.save(employeeDetails);

          return savedEmployee;
    }

    public Employee getEmployee(Long id){
        Optional<Employee> employee = employeeRepository.findByIdAndDeletedIsFalse(id);

        if(employee.isPresent()){
            return employee.get();
        }

        return null;
    }

    public List<Employee> getAllEmployee(){
        List<Employee> employees = employeeRepository.findByDeletedIsFalse();

        return employees;

    }

    public Employee updateEmployeeDetails(Long id , Employee employee){
        Optional<Employee> employeeDetails = employeeRepository.findByIdAndDeletedIsFalse(id);   // Optional gives the values if Present otherwise null

        if(employeeDetails.isEmpty()){
            return null;
        }

        Employee detailsToSave = employeeDetails.get();

        detailsToSave.setName(employee.getName());
        detailsToSave.setAddress(employee.getAddress());
        detailsToSave.setDepartment(employee.getDepartment());
        detailsToSave.setPhoneNo(employee.getPhoneNo());
        detailsToSave.setEmail(employee.getEmail());
        detailsToSave.setSalary(employee.getSalary());

        return employeeRepository.save(detailsToSave);
    }

    public Boolean deleteEmployee(Long id){
        Boolean isEmployee = employeeRepository.existsById(id);

        if(!isEmployee) return false;

        employeeRepository.deleteById(id);
        return true;

    }

    public void deleteAllEmployee(){
        employeeRepository.deleteAll();
    }

    public Boolean deleteSoftly(Long id){
        Optional<Employee> existingStudent = employeeRepository.findByIdAndDeletedIsFalse(id);

        if(existingStudent.isEmpty()){
            return false;
        }

        Employee employeeTosave = existingStudent.get();
        employeeTosave.setDeleted(true);

        employeeRepository.save(employeeTosave);
        return true;
    }
}
