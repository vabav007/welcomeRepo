Feature: Update Employee
  The microservice provides a service to update an employee,
  based on it's unique ID.
  We can overwrite the employee's existing First Name, Last Name and email ID.

  Scenario:
    Given there is an update request based on ID
    When there exists an employee on that ID
    Then the employee information can be overwritten and updated in database