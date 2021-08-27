Feature: Delete Employee
  The microservice provides a service to delete an employee based on ID,
  The request is based on employee ID
  we delete the particular employee

  Scenario:
    Given there is a delete employee request based on ID
    When there exists an employee on that ID
    Then the employee information should be deleted from database