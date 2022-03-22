package com.springboot.videoservicenew.app.controller;

import com.springboot.videoservicenew.app.model.RoleModel;
import com.springboot.videoservicenew.app.model.UserModel;
import com.springboot.videoservicenew.app.service.service2.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.management.relation.Role;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    //we use constructor injection here, same as in Service
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<UserModel>> getUsers(){
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @GetMapping("/user/save")
    public ResponseEntity<UserModel> saveUser(@RequestBody UserModel user){
        return ResponseEntity.ok().body(userService.saveUser(user));
    }

    @GetMapping("/role/save")
    public ResponseEntity<RoleModel> saveRole(@RequestBody RoleModel role){
        return ResponseEntity.ok().body(userService.saveRole(role));
    }




}
