package com.example.employeeTDD.demo.Repository;

import com.example.employeeTDD.demo.Entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Integer> {

}
