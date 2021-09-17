Feature: Create Employee
  The microservice provides a service to create an employee,
  based on First Name, Last Name and email ID.
  Each employee is allocated an auto generated unique ID as well.

  Scenario:
    Given there is a new create employee request
    When we have entered the required employee information
    Then the employee record is saved in the database

Feature: Delete Employee
  The microservice provides a service to delete an employee based on ID,
  The request is based on employee ID
  we delete the particular employee

  Scenario:
    Given Employees exist in the database
    When I send a delete employee request with the employee ID
    Then the employee information should be deleted

Feature: Get Employee
  The microservice provides a service to get an employee or list of all employees,
  If the request is based on ID, then we return the particular employee
  Otherwise return the list of all employees in database

  Scenario:
    Given there is a get employee request based on ID
    When there exists an employee on that ID
    Then the employee information should be returned back

  Scenario:
    Given there is a get employee request not based on ID
    Then return list of all employees from the database

Feature: Update Employee
  The microservice provides a service to update an employee,
  based on it's unique ID.
  We can overwrite the employee's existing First Name, Last Name and email ID.

  Scenario:
    Given there is an update request based on ID
    When the employee exists
    Then the employee information can be overwritten and updated in database