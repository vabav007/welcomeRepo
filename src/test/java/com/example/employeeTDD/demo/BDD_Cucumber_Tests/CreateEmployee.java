package com.example.employeeTDD.demo.BDD_Cucumber_Tests;

import com.example.employeeTDD.demo.Entity.Employee;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;

public class CreateEmployee {
    public CreateEmployee() {
        Given("^there is a new create employee request$", () -> {
            String addURI = "employee/create";
                    System.out.println("Add URL:" +addURI);
                    });
        When("^we have entered the required employee information$", () -> {
        });

        Then("^the employee record is saved in the database$", () -> {
        });
    }
}
