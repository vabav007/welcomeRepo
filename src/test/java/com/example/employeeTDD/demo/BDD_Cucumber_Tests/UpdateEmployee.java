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

public class UpdateEmployee {

    @MockBean
    private EmployeeService service;
    @MockBean
    private EmployeeRepository repository;
    @MockBean
    private EmployeeController controller;

    public UpdateEmployee() {
        Employee employee =new Employee(1, "Ed","Hardy","eh@gmail.com" );

        Given(("^there is an update request based on ID$", () -> {
            controller.updateEmployee(1,employee);
            Assertions.assertEquals(employee.getId(),1);
            employee.setFirstName("Matt");
            Assertions.assertEquals(employee.getFirstName(),"Matt");
        });

        When(("^there exists an employee on that ID$", () -> {
            this.service.findById(1);
            Assertions.assertNotNull(employee);
        });

        Then(("^the employee information can be overwritten and updated in database$", () -> {
            employee.setFirstName("Matt");
            employee.setLastName("Henry");
            employee.setEmailId("mh@gmail.com");
            this.repository.save(employee);

            Assertions.assertAll("Verify all conditions for an updated employee", new Executable[]{() -> {
                Assertions.assertEquals("1", employee.getId());
            }, () -> {
                Assertions.assertEquals("Matt", employee.getFirstName());
            }, () -> {
                Assertions.assertEquals("Henry", employee.getLastName());
            }
            });

        });
    }
}
