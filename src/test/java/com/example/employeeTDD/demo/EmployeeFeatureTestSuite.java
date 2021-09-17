package com.example.employeeTDD.demo;

import com.example.employeeTDD.demo.ControllerTest.EmployeeControllerTest;
import com.example.employeeTDD.demo.RepositoryTest.EmployeeRepositoryTest;
import com.example.employeeTDD.demo.ServiceTest.EmployeeServiceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses ({ EmployeeServiceTest.class,
        EmployeeControllerTest.class, EmployeeRepositoryTest.class })
public class EmployeeFeatureTestSuite {

    // intentionally empty - Test Suite Setup (annotations) is sufficient
}
