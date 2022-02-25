package com.springboot.videoservice.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.videoservice.app.model.UserModel;
import com.springboot.videoservice.app.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController { //Controller depends on Service layer

	@Autowired
	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	// build CREATE User REST API
	@PostMapping
	public ResponseEntity<UserModel> saveUserEntity(@RequestBody UserModel userModel){
	   return new ResponseEntity<UserModel>(userService.saveUser(userModel), HttpStatus.CREATED);	
	}
	
	 // build GET ALL Users REST API, to return ALL Channel from DB
	@GetMapping
	public List<UserModel> getAllUsers(){
	   return userService.getAllUsers();	
	}
}
