package com.example.employeeTDD.demo.RepositoryTest;

import com.example.employeeTDD.demo.Entity.Employee;
import com.example.employeeTDD.demo.Repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

//import java.util.concurrent.Flow;

public class EmployeeRepositoryTest<Mono> {

    @Autowired
    EmployeeRepository repository;

    @Test
    public void testRepositoryShouldSave(){
        Employee employee = repository.save((new Employee(2,"Jenny","Johnson","")));




    }

}
