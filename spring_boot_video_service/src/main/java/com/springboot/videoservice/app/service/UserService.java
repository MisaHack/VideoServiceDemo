package com.springboot.videoservice.app.service;

import java.util.List;

import com.springboot.videoservice.app.model.UserModel;

public interface UserService {
   UserModel saveUser(UserModel user);
   List<UserModel> getAllUsers();
   UserModel getUserById(long id);
   UserModel updateUser(UserModel user, long id);
   void deleteUser(long id);
}
