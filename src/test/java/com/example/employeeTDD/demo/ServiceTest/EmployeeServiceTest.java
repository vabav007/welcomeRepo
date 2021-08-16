package com.example.employeeTDD.demo.ServiceTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import com.example.employeeTDD.demo.Entity.Employee;
import com.example.employeeTDD.demo.Repository.EmployeeRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class EmployeeServiceTest {

    @Autowired
    @MockBean
    private EmployeeService service;
    @MockBean
    @Autowired
    private EmployeeRepository repository;

    @Test
    public void testSaveEmployeeService() {

        // Create an employee
        Employee employee = new Employee();
        employee.setFirstName("Jenny");
        employee.setLastName("Johnson");
        employee.setEmailId(("jj@gmail.com"));
        service.save(employee);
        when(repository.save(any(Employee.class))).thenReturn(employee);

        // Test saving the contact
        Employee newEmployee = service.save(employee);

        // Verify the save
        assertNotNull(newEmployee);
        assertNotNull(newEmployee.getId());
        assertEquals("Jenny", newEmployee.getFirstName());
        assertEquals("Johnson", newEmployee.getLastName());
        assertEquals("jj@gmail.com",newEmployee.getEmailId());
    }

    @Test
    public void testSaveNotNull() {
        Employee employee = service.save(null);
        Assertions.assertNull(employee);
    }

    @Test
    public void testFindByIdService() {
        Employee employee = new Employee();
        employee.setFirstName("Jenny");
        when(repository.findById(anyInt())).thenReturn(Optional.of(employee));
        Optional<Employee> newEmployee = service.findById(1);
        Assertions.assertEquals(employee.getFirstName(), newEmployee.get().getFirstName());
    }

    @Test
    public void testGetAllEmployees() {
        Employee employee = new Employee();
        employee.setFirstName("Jenny");
        employee.setLastName("Jonhson");
        Employee employee2 = new Employee();
        employee2.setFirstName("Jake");
        employee2.setLastName("Johnson");
        List<Employee> mockLIst = new ArrayList <>(Arrays.asList(employee,employee2));
        when(repository.findAll()).thenReturn(mockLIst);
        List<Employee> actual = service.getAllEmployees();
        Assertions.assertEquals(mockLIst.size(), actual.size());
    }
}