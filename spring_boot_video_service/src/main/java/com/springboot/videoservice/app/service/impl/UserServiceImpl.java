package com.springboot.videoservice.app.service.impl;

import java.util.List;
import java.util.Optional;

import com.springboot.videoservice.app.exception.ResourceNotFoundException;
import com.springboot.videoservice.app.model.UserModel;
import com.springboot.videoservice.app.repository.UserRepository;
import com.springboot.videoservice.app.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserModel saveUser(UserModel user) {
		return userRepository.save(user);
	}

	@Override
	public List<UserModel> getAllUsers() {
	   return userRepository.findAll();
	}

	@Override
	public UserModel getUserById(long id) {
	   Optional<UserModel> user = userRepository.findById(id);
	   
	   if(user.isPresent()){
		  return user.get(); 
	   }
	   else{
		  throw new ResourceNotFoundException("User", "id", id); 
	   }
	}

	@Override
	public UserModel updateUser(UserModel user, long id) {
	   
		//we need to check does User with the given id exist in DB or not
		UserModel existingUser = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
		
		existingUser.setName(user.getName());
		
		//save existing User to DB
		userRepository.save(existingUser);
		return existingUser;
	}

	@Override
	public void deleteUser(long id) {
		
	   // check whether a User exist in DB or not
	   userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
	   
	   userRepository.deleteById(id);
	}

}
