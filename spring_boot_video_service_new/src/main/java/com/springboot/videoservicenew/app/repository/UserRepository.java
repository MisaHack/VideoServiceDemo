package com.springboot.videoservicenew.app.repository;

import com.springboot.videoservicenew.app.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    UserModel findByUserName(String username);
}
