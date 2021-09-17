package com.example.employeeTDD.demo.ControllerTest;


import com.example.employeeTDD.demo.Controller.EmployeeController;
import com.example.employeeTDD.demo.Entity.Employee;
import com.example.employeeTDD.demo.Service.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
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

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(EmployeeController.class)
@Data
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private EmployeeService service;
    @InjectMocks
    private EmployeeController controller;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddContactHappyPath() throws Exception {
        // setup mock Contact returned the mock service component
        Employee employee = new Employee();
        employee.setFirstName("Fred");

        when(service.save(employee))// check
                .thenReturn(employee);

        // simulate the form bean that would POST from the web page
        Employee employee1 = new Employee();
        employee1.setFirstName("Fred");
        employee1.setEmailId("fredj@myemail.com");

        // simulate the form submit (POST)
        mockMvc
                .perform(post("/employee", employee1))
                .andExpect(status().isOk())
                .andReturn();
    }


    @Test
    @DisplayName("create test")
    @Disabled
    public void testCreateEmployee() throws Exception {

        Employee employee = new Employee(1,"Jenny","Johnson", "jj@gmail.com");

        String inputInJson = this.mapToJson(employee); //JSON Mapper
        when(service.save(employee)).thenReturn(employee);
        RequestBuilder requestBuilder = post("/employee")
                .accept(MediaType.APPLICATION_JSON).content(inputInJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult   mvcResult = mockMvc.perform(requestBuilder).andReturn();
        String outPutInJson = mvcResult.getRequest().getContentAsString();
        Assertions.assertEquals(inputInJson, outPutInJson);

        Employee outcome = controller.createEmployee(employee);

        //Assert THAT the outcome is as expected
        Assertions.assertEquals(outcome.toString(), inputInJson);
    }

    @Test
    @Disabled
    public void testUpdateEmployeeById() throws Exception {
        Employee employee = new Employee();
        employee.setFirstName("Jenny");
        employee.setLastName("Johnson");
        employee.setEmailId("jj@gmal.com");
       // Optional<Employee> newEmployee = Optional.of(employee);

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
        List<Employee> empList = new ArrayList<>();
        empList.add(e1);
        empList.add(e2);
        empList.add(e3);
        when(service.getAllEmployees()).thenReturn(empList);
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/employee");
        MvcResult   mvcResult = mockMvc.perform(requestBuilder).andReturn();

        Assertions.assertEquals(this.mapToJson(empList),mvcResult.getResponse().getContentAsString());
    }


    @Test
    @Disabled
    public void testGetEmployeeReturnById() throws Exception {
        Employee employee = new Employee(1,"Jenny","Johnson", "jj@gmail.com");
        doReturn(Optional.of(employee)).when(service).findById(1); // doReturn-when logic

        when(service.findById(1).isPresent()).thenReturn(Boolean.valueOf(employee.toString())); // when-thenReturn logic check for the thenReturn part

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/employee/{id}"+1); //check syntax
        MvcResult   mvcResult = mockMvc.perform(requestBuilder).andReturn();

        Assertions.assertEquals(this.mapToJson(employee), mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void testDeleteEmployee() throws Exception {
        int id = 1;
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/employee/"+id);
        mockMvc.perform(requestBuilder).andReturn();
        Assertions.assertNull(requestBuilder.toString());
    }


    //defining JSON Mapper
    private String mapToJson(Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }


}

