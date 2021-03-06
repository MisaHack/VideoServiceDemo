package com.springboot.videoservice.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
   
	// http://localhost:8090/student
	@GetMapping("/student")
	public Student getStudent(){
	   return new Student("Pera", "Peric");
	}
	
	@GetMapping("/students")
	public List<Student> getStudents(){
	   
	   List<Student> students = new ArrayList<>();
	   students.add(new Student("Misa","Misic"));
	   students.add(new Student("Stefan","Stefic"));
	   students.add(new Student("Aleksandar","Aleksic"));
	   
	   return students;
	   
	}
	
	// http://localhost:8080/student/misa/lihvarcek
	@GetMapping("student/{firstName}/{lastName}")
	public Student studentPathVariable(@PathVariable("firstName") String firstName_1, @PathVariable("lastName") String lastName_1) {
	   return new Student(firstName_1, lastName_1);	
	}
	
	//building Rest API to handle query parameters
	// http://localhost:8090/student/query?firstName=Misa&lastName=Misic
	@GetMapping("/student/query")
	public Student studentQueryParam(@RequestParam(name="firstName") String firstName,@RequestParam(name="lastName") String lastName){
		
	   return new Student(firstName, lastName);	
	}
}
