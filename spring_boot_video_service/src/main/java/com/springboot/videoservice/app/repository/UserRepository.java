package com.springboot.videoservice.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.videoservice.app.model.User;

public interface UserRepository extends JpaRepository<User, String> {

}
