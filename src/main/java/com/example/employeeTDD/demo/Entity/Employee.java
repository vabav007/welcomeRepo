package com.example.employeeTDD.demo.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String firstName;
private String lastName;
private String emailId;


}
