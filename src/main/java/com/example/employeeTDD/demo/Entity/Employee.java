package com.example.employeeTDD.demo.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Employee {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String firstName;
private String lastName;
private String emailId;

}
