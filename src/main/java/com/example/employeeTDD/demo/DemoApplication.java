package com.example.employeeTDD.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.SpringVersion;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	//	SpringApplication springApplication=new SpringApplication(DemoApplication.class);
	//	System.out.println("Spring Core Version:- " + SpringVersion.getVersion());
	//	springApplication.run(args);

	}
}
