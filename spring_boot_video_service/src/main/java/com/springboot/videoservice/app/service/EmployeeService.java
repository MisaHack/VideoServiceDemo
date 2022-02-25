package com.springboot.videoservice.app.service;

import java.util.List;

import com.springboot.videoservice.app.model.EmployeeModel;

public interface EmployeeService {
   EmployeeModel saveEmployee(EmployeeModel employee);
   List<EmployeeModel> getAllEmployees();
   EmployeeModel getEmployeeById(long id);
}
