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