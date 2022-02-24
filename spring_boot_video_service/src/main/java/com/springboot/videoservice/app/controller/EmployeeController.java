package com.springboot.videoservice.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.videoservice.app.model.EmployeeModel;
import com.springboot.videoservice.app.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
   
   @Autowired
   private EmployeeService employeeService;
   
   public EmployeeController(EmployeeService employeeService){
	  super();
	  this.employeeService = employeeService;
   }
   
   // build create Employee REST API
   // we are using ResponseEntity class as a return because we can provide
   // complete response details in this class 
   //(we can add status to to this class, header etc...)
   
   //We are using @PostMapping because we will handle POST HTTP Request
   //We are sending Employee object because this POST request contains Employee JSON object,
   //and that we need to bind to the Java object, for that we will have to use @RequestBody
   
   //We are using ResponseEntity class to return <body, status>
   @PostMapping
   public ResponseEntity<EmployeeModel> saveEmployee(@RequestBody EmployeeModel employee){
	  return new ResponseEntity<EmployeeModel>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
   }
}
