package com.xavier.springsecurity2.controller;

import com.xavier.springsecurity2.Utils.Utils;
import com.xavier.springsecurity2.models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
public class UserController {


    @GetMapping(path = "{id}")
    public User getPersonnel(@PathVariable("id") Integer id){
        return Utils.getUsers()
                .stream()
                .filter(person -> id.equals(person.getId()))
                .findFirst()
                .orElseThrow(()->new IllegalStateException("Personnel with "+id+" not found."));
    }
}
