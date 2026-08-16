package com.demo.employee_management.controller;
import com.demo.employee_management.entity.Employee;
import com.demo.employee_management.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Student details added Succesfully");
    }

    @GetMapping("/get")
    public ResponseEntity<Employee> getEmployoyee(@RequestParam Long id) {
        Employee employee = employeeService.getEmployee(id);

        if (employee == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);

        }

        return ResponseEntity.ok(employee);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Employee>> getAllEmployee() {
        List<Employee> employees = employeeService.getAllEmployee();

        if (employees == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }

        return ResponseEntity.ok(employees);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateEmployeeDetails(@RequestParam Long id , @RequestBody Employee employee){
        Employee updatedDetails = employeeService.updateEmployeeDetails(id , employee);

            if(updatedDetails == null){
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("No Such Employee Found");
            }

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("Details Updated SuccessFully!");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteEmployee(@RequestParam Long id) {
        Boolean isDeleted = employeeService.deleteEmployee(id);

        if (!isDeleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok("Deleted Succesfully");
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAllEmployee(){
        employeeService.deleteAllEmployee();
        return ResponseEntity.ok("All Emplyoee Deleted Successfully");

    }

    @DeleteMapping("/delete-soft")
    public ResponseEntity<String> deleteSoftly(@RequestParam Long id){

        Boolean isDeleted = employeeService.deleteSoftly(id);
        if(!isDeleted){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok("The Employee is Softly Delected ");
    }
}
