package com.example.employeeTDD.demo.ControllerTest;


import com.example.employeeTDD.demo.Controller.EmployeeController;
import com.example.employeeTDD.demo.Entity.Employee;
import com.example.employeeTDD.demo.Service.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(EmployeeController.class)
@AutoConfigureMockMvc
@SpringBootTest
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    @Autowired
    private EmployeeService service;
    @MockBean
    @Autowired
    private EmployeeController controller;


    @Test
    @DisplayName("POST /create/1 - Found")
    @Disabled
    public void testCreateEmployee() throws Exception {

        Employee employee = new Employee(1,"Jenny","Johnson", "jj@gmail.com");

        String inputInJson = this.mapToJson(employee); //JSON Mapper
        when(service.save(any(Employee.class))).thenReturn(employee);
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/create")
                .accept(MediaType.APPLICATION_JSON).content(inputInJson)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult   mvcResult = mockMvc.perform(requestBuilder).andReturn();
        String outPutInJson = mvcResult.getRequest().getContentAsString();
        Assertions.assertEquals(inputInJson, outPutInJson);
    }

    @Test
    @Disabled
    public void testUpdateEmployeeById() throws Exception {
        Employee employee = new Employee();
        employee.setFirstName("Jenny");
        employee.setLastName("Johnson");
        employee.setEmailId("jj@gmal.com");
        Optional<Employee> newEmployee = Optional.of(employee);

        String inputInJson = this.mapToJson(employee); //JSON Mapping

        when(service.findById(any()))
                .thenReturn(Optional.of(employee)); // check any method
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/employee/{id}"+1) //check syntax
                .accept(MediaType.APPLICATION_JSON).content(inputInJson)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        String outPutInJson = mvcResult.getRequest().getContentAsString();
        Assertions.assertEquals(inputInJson, outPutInJson);
    }

    @Test
    @Disabled
    public void testGetAllEmployees() throws Exception {
        Employee e1 = new Employee();
        e1.setFirstName("Jenny");
        Employee e2 = new Employee();
        e2.setFirstName("Jake");
        Employee e3 = new Employee();
        e3.setFirstName("Johnson");
        List<Employee> empList = new ArrayList<Employee>(Arrays.asList(e1,e2,e3)); //check Arrays in JUnit
        when(service.getAllEmployees()).thenReturn(empList);
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/getAllEmployees");
        MvcResult   mvcResult = mockMvc.perform(requestBuilder).andReturn();

        Assertions.assertEquals(this.mapToJson(empList),mvcResult.getResponse().getContentAsString());
    }


    @Test
    @Disabled
    public void testGetEmployeeReturnById() throws Exception {
        Employee employee = new Employee(1,"Jenny","Johnson", "jj@gmail.com");
        doReturn(Optional.of(employee)).when(service).findById(1);

        when(service.findById(1).thenReturn(employee));

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/getEmployee/{id}"+1); //check syntax
        MvcResult   mvcResult = mockMvc.perform(requestBuilder).andReturn();

        Assertions.assertEquals(this.mapToJson(employee), mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void testDeleteEmployee() throws Exception {
        int id = 1;
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/delete/"+id);
        mockMvc.perform(requestBuilder).andReturn();
        Assertions.assertNull(requestBuilder);
    }


    //defining JSON Mapper
    private String mapToJson(Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }


}

