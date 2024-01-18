package com.miu.lab.lab1.controllers;

import com.miu.lab.lab1.entity.dtos.PostDto;
import com.miu.lab.lab1.entity.dtos.requestDto.UserRequestDto;
import com.miu.lab.lab1.entity.dtos.responseDto.UserResponseDto;
import com.miu.lab.lab1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<UserResponseDto> getUsers(){
        return userService.getUsers();
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createUser(@RequestBody UserRequestDto userRequestDto){
        userService.createNewUser(userRequestDto);
    }

    @GetMapping ("/{id}/posts")
    public List<PostDto> getPostFromUserId(@PathVariable long id){
        return userService.getPostFromUserId(id);
    }
}
