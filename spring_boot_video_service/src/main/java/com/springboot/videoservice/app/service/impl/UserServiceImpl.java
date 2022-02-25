package com.springboot.videoservice.app.service.impl;

import java.util.List;

import com.springboot.videoservice.app.model.UserModel;
import com.springboot.videoservice.app.repository.UserRepository;
import com.springboot.videoservice.app.service.UserService;

public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	public UserServiceImpl() {
	   super();
	}

	public UserServiceImpl(UserRepository userRepository) {
		super();
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

}
