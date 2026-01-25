package com.example.cleaning.controller;
import com.example.cleaning.model.Employee;
import com.example.cleaning.service.EmployeeService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/dipendenti")
    public List<Employee> getEmployee() {
        return employeeService.findAll();
    }

    @QueryMapping
    public List<Employee> employees() {
        return employeeService.findAll();
    }

    @QueryMapping
    public Employee employee(@Argument Long id) {
        return employeeService.findById(id).orElse(null);
    }
}
