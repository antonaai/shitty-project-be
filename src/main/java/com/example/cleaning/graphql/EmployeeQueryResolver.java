package com.example.cleaning.graphql;
import com.example.cleaning.model.Employee;
import com.example.cleaning.repository.EmployeeRepository;
import org.springframework.stereotype.Component;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.Argument;

import java.util.List;

@Component
public class EmployeeQueryResolver {

    private final EmployeeRepository employeeRepository;

    public EmployeeQueryResolver(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @QueryMapping
    public List<Employee> employees() {
        return employeeRepository.findAll();
    }

    @QueryMapping
    public Employee employee(@Argument Long id) {
        return employeeRepository.findById(id).orElse(null);
    }
}
