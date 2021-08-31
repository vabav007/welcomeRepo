package com.example.employeeTDD.demo.BDD_Cucumber_Tests;

import com.example.employeeTDD.demo.Controller.EmployeeController;
import com.example.employeeTDD.demo.Entity.Employee;
import com.example.employeeTDD.demo.Repository.EmployeeRepository;
import com.example.employeeTDD.demo.Service.EmployeeService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.function.Executable;
import org.springframework.boot.test.mock.mockito.MockBean;

public class GetEmployee {
    @MockBean
    private EmployeeService service;
    @MockBean
    private EmployeeRepository repository;
    @MockBean
    private EmployeeController controller;

    public GetEmployee() {


        Employee employee =new Employee(1, "Ed","Hardy","eh@gmail.com" );

        Given(("^there is a get employee request based on ID$", () -> {
            this.controller.getEmployee(1);
            this.service.findById(1);
            this.repository.findById(1);
        });

        When(("^there exists an employee on that ID$", () -> {
            Assertions.assertNotNull(employee);
        });

        Then(("^the employee information should be returned back$", () -> {
            Assertions.assertAll("Verify all conditions for a requested by ID employee", new Executable[]{() -> {
                Assertions.assertEquals("1", employee.getId());
            }, () -> {
                Assertions.assertEquals("Ed", employee.getFirstName());
            }, () -> {
                Assertions.assertEquals("Hardy", employee.getLastName());
            }
            });
        });

        Given(("^there is a get employee request not based on ID$", () -> {
            this.controller.getAllEmployee();
            this.service.getAllEmployees();
            this.repository.findAll();
        });

        Then(("^return list of all employees from the database$", () -> {
            return this.repository.findAll();
        });
    }
}
