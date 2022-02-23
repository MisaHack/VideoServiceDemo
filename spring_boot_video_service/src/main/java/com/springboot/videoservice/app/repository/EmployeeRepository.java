package com.springboot.videoservice.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.videoservice.app.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
