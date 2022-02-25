package com.springboot.videoservice.app.service;

import java.util.List;

import com.springboot.videoservice.app.model.UserModel;

public interface UserService {
   UserModel saveUser(UserModel user);
   List<UserModel> getAllUsers();
}
