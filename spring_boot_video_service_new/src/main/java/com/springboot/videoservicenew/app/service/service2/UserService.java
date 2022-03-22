package com.springboot.videoservicenew.app.service.service2;

import com.springboot.videoservicenew.app.model.RoleModel;
import com.springboot.videoservicenew.app.model.UserModel;

import java.util.List;

public interface UserService {
    UserModel saveUser(UserModel user);
    RoleModel saveRole(RoleModel role);
    //if all user names are unique this will work
    void addRoleToUser(String userName, String roleName);
    UserModel getUser(String userName);
    List<UserModel> getUsers();
}
