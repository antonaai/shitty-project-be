package com.example.cleaning.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.cleaning.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
