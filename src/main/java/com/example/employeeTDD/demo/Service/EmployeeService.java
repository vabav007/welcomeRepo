package com.example.employeeTDD.demo.Service;

import com.example.employeeTDD.demo.Entity.Employee;
import com.example.employeeTDD.demo.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Optional<Employee> findById(int id)  {
        return employeeRepository.findById(id);
    }

    public List<Employee> getAllEmployees() {
        return (List<Employee>) employeeRepository.findAll();
    }

    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }
}
