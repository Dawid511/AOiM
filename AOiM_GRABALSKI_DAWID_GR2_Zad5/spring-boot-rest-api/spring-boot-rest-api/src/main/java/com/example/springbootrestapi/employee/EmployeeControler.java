package com.example.springbootrestapi.employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeControler {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeControler(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }
/*
    @PostMapping
    public void addStudent(@Valid @RequestBody Employee student) {
        employeeService.addNewEmployee(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(
            @PathVariable("studentId") Long studentId) {
        employeeService.deleteEmployee(studentId);
    }*/


}
