package com.springboot.videoservice.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
   // method that returns Stream --> Hello World
   // ovaj metod ce vracati GET HTTP request
   // mozemo definisati i URL za ovaj REST API
   // http://localhost:8080/return-hello-world
   @GetMapping("/return-hello-world")
   public String printHelloWorld() {
	  return "Hello World !"; 
   }
}
