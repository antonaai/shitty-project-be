package com.example.cleaning.service;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.example.cleaning.model.Employee;
import com.example.cleaning.repository.EmployeeRepository;

@Service
public class EmployeeService {
    private final EmployeeRepository repo;

    public EmployeeService(EmployeeRepository repo) {
        this.repo = repo;
    }
    public List<Employee> findAll() {
        return repo.findAll();
    }

    public Optional<Employee> findById(@Argument Long id){
        return repo.findById(id);
    }
    public Employee save(Employee e) {
        return repo.save(e);
    }
}
