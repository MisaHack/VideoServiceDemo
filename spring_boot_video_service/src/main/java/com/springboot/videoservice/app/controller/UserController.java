package com.springboot.videoservice.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	 // build GET ALL Users REST API, to return ALL Users from DB
	@GetMapping
	public List<UserModel> getAllUsers(){
	   return userService.getAllUsers();	
	}
	
	// build GET User BY ID REST API, to return User BY ID from DB
	// http://localhost:8080/api/user/1
	// this is dynamic path variable
	@GetMapping("{id}")
	public ResponseEntity<UserModel> getUserById(@PathVariable("id") long user_id){
	   return new ResponseEntity<UserModel>(userService.getUserById(user_id), HttpStatus.OK);	
	}
	
	// build UPDATE User Data REST API, to Update User Data fields from DB
	// http://localhost:8080/api/user/1
	// we use ResponseEntity as a return type
	@PutMapping("{id}")
	public ResponseEntity<UserModel> updateUser(@PathVariable("id") long id, @RequestBody UserModel user){
	   return new ResponseEntity<UserModel>(userService.updateUser(user, id), HttpStatus.OK);
	}
	
	// build DELETE Employee Data REST API
	// http://localhost:8080/api/user/1	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") long id){
	   
	   //delete User from DB
	   userService.deleteUser(id);
	   
	   return new ResponseEntity<String>("User deleted successfully !", HttpStatus.OK);
	}
}
