package com.springboot.videoservicenew.app.service.impl;

import com.springboot.videoservicenew.app.model.RoleModel;
import com.springboot.videoservicenew.app.model.UserModel;
import com.springboot.videoservicenew.app.repository.RoleRepository;
import com.springboot.videoservicenew.app.repository.UserRepository;
import com.springboot.videoservicenew.app.service.service2.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
//@RequiredArgsConstructor - with this annotation Lombok creates constructor
// for injection for us
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    //injection by constructor
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository){
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserModel saveUser(UserModel user) {
        log.info("Saving new User {} to the database", user.getUserName());
        return userRepository.save(user);
    }

    @Override
    public RoleModel saveRole(RoleModel role) {
        log.info("Saving new Role {} to the database", role.getRoleName());
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        log.info("Adding Role {} to User {} ", roleName, userName);
        UserModel user = userRepository.findByUserName(userName);
        RoleModel role = roleRepository.findByRoleName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public UserModel getUser(String userName) {
        log.info("Fetching User {}", userName);
        return userRepository.findByUserName(userName);
    }

    @Override
    public List<UserModel> getUsers() {
        log.info("Fetching all Users");
        return userRepository.findAll();
    }
}
