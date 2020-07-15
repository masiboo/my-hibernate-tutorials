package com.example.jointablebasedonetoone.controller;

import com.example.jointablebasedonetoone.model.Employee;
import com.example.jointablebasedonetoone.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    public static final String EMPLOYEE = "/employee";

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping(EMPLOYEE)
    public List<Employee> getUsers() {
        List<Employee> employees = employeeRepository.findAll();
        return employees;
    }

    @PostMapping(EMPLOYEE)
    public Employee addUser(@RequestBody Employee user) {
        Employee savedEmployee = employeeRepository.save(user);
        return savedEmployee;
    }

}
