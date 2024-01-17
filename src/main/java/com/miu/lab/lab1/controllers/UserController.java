package com.miu.lab.lab1.controllers;

import com.miu.lab.lab1.entity.dtos.UserDto;
import com.miu.lab.lab1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<UserDto> getUsers(){
        return null;
    }
}
