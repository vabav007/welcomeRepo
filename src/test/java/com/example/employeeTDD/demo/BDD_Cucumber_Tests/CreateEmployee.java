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


public class CreateEmployee {

    @MockBean
    private EmployeeService service;
    @MockBean
    private EmployeeRepository repository;
    @MockBean
    private EmployeeController controller;

    public CreateEmployee() {

        Employee employee =new Employee();
        Given(("^there is a new create employee request$", () -> {
            String addURI = "employee/create"; // check REST implementation
            employee.setId(1);
            employee.setFirstName("Matt");
            employee.setLastName("Henry");
            employee.setEmailId("mh@gmail.com");
                    this.controller.createEmployee(employee);
                    });

        When(("^we have entered the required employee information$", () -> {

            Assertions.assertNotNull(employee);
            Assertions.assertAll("Verify all conditions for a created employee", new Executable[]{() -> {
                Assertions.assertEquals("1", employee.getId());
            }, () -> {
                Assertions.assertEquals("Matt", employee.getFirstName());
            }, () -> {
                Assertions.assertEquals("Henry", employee.getLastName());
            }, () -> {
                Assertions.assertEquals("mh@gmail.com", employee.getEmailId());
            }
            });
            this.service.save(employee);
        });

        Then(("^the employee record is saved in the database$", () -> {
            this.repository.save(employee);
        });
    }
}
