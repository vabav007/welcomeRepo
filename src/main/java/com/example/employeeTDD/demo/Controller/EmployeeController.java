package com.example.employeeTDD.demo.Controller;

import com.example.employeeTDD.demo.Entity.Employee;
import com.example.employeeTDD.demo.Exception.EmployeeNotFoundException;
import com.example.employeeTDD.demo.Service.EmployeeService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) { this.employeeService = employeeService; }

    @PostMapping("/employee")
    public @ResponseBody
    Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployee(
            @PathVariable(value = "id") int id,
            @RequestBody Employee employee) throws ResourceNotFoundException {
        Employee employee1 = employeeService.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found on :: "+ id));

        employee1.setFirstName(employee1.getFirstName());
        employee1.setLastName(employee1.getLastName());
        employee1.setEmailId(employee1.getEmailId());
        final Employee updatedEmployee = employeeService.save(employee1);
        return ResponseEntity.ok(updatedEmployee);
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable int id) {
        return employeeService.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("no employee available."));
    }

    @GetMapping("/employee")
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployees();
    }

    @DeleteMapping("/employee/{id}")
    public void deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
    }

}

