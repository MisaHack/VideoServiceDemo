package com.springboot.videoservice.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.videoservice.app.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, String> {

}
