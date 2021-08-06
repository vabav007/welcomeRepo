package com.example.employeeTDD.demo.Exception;

public class EmployeeNotFoundException extends RuntimeException{

    public EmployeeNotFoundException(String exception) {
        super(exception);
    }
}
