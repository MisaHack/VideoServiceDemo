package com.springboot.videoservice.app.service.impl;

import org.springframework.stereotype.Service;

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
}
