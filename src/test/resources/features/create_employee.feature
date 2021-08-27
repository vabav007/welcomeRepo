Feature: Create Employee
  The microservice provides a service to create an employee,
  based on First Name, Last Name and email ID.
  Each employee is allocated an auto generated unique ID as well.

  Scenario:
    Given there is a new create employee request
    When we have entered the required employee information
    Then the employee record is saved in the database