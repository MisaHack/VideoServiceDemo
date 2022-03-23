package com.springboot.videoservicenew.app.controller;

import com.springboot.videoservicenew.app.model.RoleModel;
import com.springboot.videoservicenew.app.model.UserModel;
import com.springboot.videoservicenew.app.service.service2.UserService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.management.relation.Role;
import java.net.URI;
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

    @PostMapping("/user/save")
    public ResponseEntity<UserModel> saveUser(@RequestBody UserModel user){
        //created(uri) - returns more precise information
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }

    @PostMapping("/role/save")
    public ResponseEntity<RoleModel> saveRole(@RequestBody RoleModel role){
        //ok() - returns status 200
        return ResponseEntity.ok().body(userService.saveRole(role));
    }

    //service call is going to return VOID, so it does not matter what we return
    @PostMapping("/role/addToUser")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm form){
        //ok() - returns status 200
        userService.addRoleToUser(form.getUserName(), form.getRoleName());
        return ResponseEntity.ok().build();
    }

}

//we are using this helper class because "addRoleToUser" requires username and password
//so this is the name we can provide those informations
@Data
class RoleToUserForm{
    private String userName;
    private String roleName;
}