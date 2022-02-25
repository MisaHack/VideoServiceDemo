package com.springboot.videoservice.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import com.springboot.videoservice.app.exception.ResourceNotFoundException;
import com.springboot.videoservice.app.model.EmployeeModel;
import com.springboot.videoservice.app.repository.EmployeeRepository;
import com.springboot.videoservice.app.service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(){
	}
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public EmployeeModel saveEmployee(EmployeeModel employee) {
	   return employeeRepository.save(employee);
	}

	@Override
	public List<EmployeeModel> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public EmployeeModel getEmployeeById(long id) {
	   Optional<EmployeeModel> employee = employeeRepository.findById(id);
	   
	   if(employee.isPresent()){
		  return employee.get(); 
	   }
	   else {
		  throw new ResourceNotFoundException("Employee", "id", id);   
	   }
	}

	@Override
	public EmployeeModel updateEmployee(EmployeeModel employee, long id) {
	   
		//we need to check does employeee with the given id exist in DB or not
	    EmployeeModel existingEmployee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
	    
	    existingEmployee.setFirstName(employee.getFirstName());
	    existingEmployee.setLastName(employee.getLastName());
	    existingEmployee.setEmail(employee.getEmail());
	    
	    //save existing employee to DB
	    employeeRepository.save(existingEmployee);
	    return existingEmployee;
	    
	}
}
