package com.example.employeeTDD.demo.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Employee {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="employee_id")
private int id;

@Column(name = "first_name", nullable = false)
private String firstName;

@Column(name = "last_name", nullable = false)
private String lastName;

@Column(name = "email", nullable = false)
private String emailId;

}
