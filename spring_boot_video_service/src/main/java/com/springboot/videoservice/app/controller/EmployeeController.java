package com.springboot.videoservice.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.videoservice.app.model.EmployeeModel;
import com.springboot.videoservice.app.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController { //Controller depends on Service layer
   
   @Autowired
   private EmployeeService employeeService;
   
   public EmployeeController(EmployeeService employeeService){
	  super();
	  this.employeeService = employeeService;
   }
   
   // build CREATE Employee REST API
   
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
   
   // build GET ALL Employees REST API, to return ALL Employees from DB
   @GetMapping
   public List<EmployeeModel> getAllEmployees(){
	  return employeeService.getAllEmployees(); 
   }
   
   // build GET Employee BY ID REST API, to return Employee BY ID from DB
   // http://localhost:8080/api/employees/1
   // this is dynamic path variable
   @GetMapping("{id}")
   public ResponseEntity<EmployeeModel> getEmployeeById(@PathVariable("id") long employee_id){
	  return new ResponseEntity<EmployeeModel>(employeeService.getEmployeeById(employee_id), HttpStatus.OK);
   }
   
   // build UPDATE Employee Data REST API, to Update Employee Data fields from DB
   // http://localhost:8080/api/employees/1
   // we use ResponseEntity as a return type
   @PutMapping("{id}")
   public ResponseEntity<EmployeeModel> updateEmployee(@PathVariable("id") long id, @RequestBody EmployeeModel employee){
	  return new ResponseEntity<EmployeeModel>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
   }
   
   
}
