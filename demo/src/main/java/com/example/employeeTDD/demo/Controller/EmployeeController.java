package com.example.employeeTDD.demo.Controller;

import com.example.employeeTDD.demo.Entity.Employee;
import com.example.employeeTDD.demo.Exception.EmployeeNotFoundException;
import com.example.employeeTDD.demo.Repository.EmployeeRepository;
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

    @PostMapping("/create")
    public @ResponseBody
    Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployee(
            @PathVariable(value = "id") Long id,
            @RequestBody Employee employee) throws ResourceNotFoundException {
        Employee employee1 = (Employee) EmployeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found on :: "+ id));

        employee1.setFirstName(Employee.getFirstName());
        employee1.setLastName(Employee.getLastName());
        employee1.setEmailId(Employee.getEmailId());
        final Employee updatedEmployee = EmployeeRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    @GetMapping("/getEmployee/{id}")
    public Employee getEmployee(@PathVariable int id) {
        return employeeService.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("no employee available."));
    }

    @GetMapping("/getEmployee")
    public List<Employee> getAllEmployee(@PathVariable int id) {
        return employeeService.getAllEmployees();
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public void deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
    }

}

