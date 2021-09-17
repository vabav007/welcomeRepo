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

import java.util.List;

public class MyStepdefs {

    @MockBean
    private EmployeeService service;
    @MockBean
    private EmployeeRepository repository;
    @MockBean
    private EmployeeController controller;
    Employee employee =new Employee();

    @Given("there is a new create employee request")
    public void thereIsANewCreateEmployeeRequest() {

        employee.setId(1);
        employee.setFirstName("Matt");
        employee.setLastName("Henry");
        employee.setEmailId("mh@gmail.com");
        this.controller.createEmployee(employee);
    }

    @When("we have entered the required employee information")
    public void weHaveEnteredTheRequiredEmployeeInformation() {
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
    }

    @Then("the employee record is saved in the database")
    public void theEmployeeRecordIsSavedInTheDatabase() {
        this.repository.save(employee);
    }

    @Given("Employees exist in the database")
    public void employeesExistInTheDatabase() {
        this.controller.deleteEmployee(1);
    }

    @When("I send a delete employee request with the employee ID")
    public void iSendADeleteEmployeeRequestWithTheEmployeeID() {
        Assertions.assertNotNull(employee);
        this.service.deleteEmployee(1);
    }

    @Then("the employee information should be deleted")
    public void theEmployeeInformationShouldBeDeleted() {
        this.repository.deleteById(1);
        Assertions.assertNull(employee);
    }

    @Given("there is a get employee request based on ID")
    public void thereIsAGetEmployeeRequestBasedOnID() {
        this.controller.getEmployee(1);
    }

    @When("there exists an employee on that ID")
    public void thereExistsAnEmployeeOnThatID() {
        Assertions.assertNotNull(employee);
    }

    @Then("the employee information should be returned back")
    public void theEmployeeInformationShouldBeReturnedBack() {
        Assertions.assertAll("Verify all conditions for a requested by ID employee", new Executable[]{() -> {
            Assertions.assertEquals("1", employee.getId());
        }, () -> {
            Assertions.assertEquals("Ed", employee.getFirstName());
        }, () -> {
            Assertions.assertEquals("Hardy", employee.getLastName());
        }
        });
    }

    @Given("there is a get employee request not based on ID")
    public void thereIsAGetEmployeeRequestNotBasedOnID() {
        this.controller.getAllEmployee();
        this.service.getAllEmployees();
        this.repository.findAll();
    }

    @Then("return list of all employees from the database")
    public List<Employee> returnListOfAllEmployeesFromTheDatabase() {
        return (List<Employee>) this.repository.findAll();
    }

    @Given("there is an update request based on ID")
    public void thereIsAnUpdateRequestBasedOnID() {
        controller.updateEmployee(1,employee);
        Assertions.assertEquals(employee.getId(),1);
        employee.setFirstName("Matt");
        Assertions.assertEquals(employee.getFirstName(),"Matt");
    }

    @When("the employee exists")
    public void theEmployeeExists() {
        this.service.findById(1);
        Assertions.assertNotNull(employee);
    }

    @Then("the employee information can be overwritten and updated in database")
    public void theEmployeeInformationCanBeOverwrittenAndUpdatedInDatabase() {
        employee.setFirstName("Matt");
        employee.setLastName("Henry");
        employee.setEmailId("mh@gmail.com");
        this.repository.save(employee);

        Assertions.assertAll("Verify all conditions for an updated employee", new Executable[]{() -> {
            Assertions.assertEquals(1, employee.getId());
        }, () -> {
            Assertions.assertEquals("Matt", employee.getFirstName());
        }, () -> {
            Assertions.assertEquals("Henry", employee.getLastName());
        }
        });
    }
}
