package com.example.employeeTDD.demo.RepositoryTest;

import com.example.employeeTDD.demo.Entity.Employee;
import com.example.employeeTDD.demo.Repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EmployeeRepositoryTest<Mono> {

    @Autowired
    private Employee employee;
    @Autowired
    private EmployeeRepository repository;

    @Test
    public void testRepositoryShouldSave(){
        Employee employee = repository.save((new Employee(2,"Jenny","Johnson","")));

    }



}
