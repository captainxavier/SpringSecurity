package com.xavier.springsecurity2.controller;

import com.xavier.springsecurity2.Utils.Utils;
import com.xavier.springsecurity2.models.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("management/api/v1/user")
public class UserManagementController {

    @GetMapping

    public List<User> getAllUsers(){
        return Utils.getUsers();
    }

    @PostMapping
    public void registerNewUser(@RequestBody User user){
        System.out.println(user);
    }

    @DeleteMapping(path = "{userId}")
    public void deleteUser(Integer userId){
        System.out.println(userId);
    }
    @PutMapping(path = "{userId}")
    public void updateUser(Integer userId, User user){
        System.out.println(String.format("%s %s",userId, user));
    }
}
