package com.example.employeeTDD.demo.BDD_Cucumber_Tests;

import com.example.employeeTDD.demo.Controller.EmployeeController;
import com.example.employeeTDD.demo.Entity.Employee;
import com.example.employeeTDD.demo.Repository.EmployeeRepository;
import com.example.employeeTDD.demo.Service.EmployeeService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.mock.mockito.MockBean;

public class DeleteEmployee {
    @MockBean
    private EmployeeService service;
    @MockBean
    private EmployeeRepository repository;
    @MockBean
    private EmployeeController controller;

    public DeleteEmployee() {
        Employee employee =new Employee(1, "Ed","Hardy","eh@gmail.com" );

        Given(("^there is a delete employee request based on ID$", () -> {
            this.controller.deleteEmployee(1);


        });
        When(("^there exists an employee on that ID$", () -> {
            Assertions.assertNotNull(employee);
            this.service.deleteEmployee(1);
        });
        Then(("^the employee information should be deleted from database$", () -> {
            this.repository.deleteById(1);
            Assertions.assertNull(employee);
        });
    }
}
