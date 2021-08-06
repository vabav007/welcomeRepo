package com.example.employeeTDD.demo.Repository;

import com.example.employeeTDD.demo.Entity.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EmployeeRepository extends CrudRepository<Employee,Integer> {
    static Optional<Object> findById(Long id) {
    }
}
