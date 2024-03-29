package com.miu.lab.lab1.controllers;

import com.miu.lab.lab1.aspect.annotation.ExecutionTime;
import com.miu.lab.lab1.entity.dtos.PostDto;
import com.miu.lab.lab1.entity.dtos.requestDto.UserRequestDto;
import com.miu.lab.lab1.entity.dtos.responseDto.UserResponseDto;
import com.miu.lab.lab1.repo.UserRepo;
import com.miu.lab.lab1.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepo userRepo;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping
    public List<UserResponseDto> getUsers(
            @RequestParam(required = false, defaultValue = "false") boolean havingMoreThan1Pos,
            @RequestParam(required = false , defaultValue = "0") int numberOfPosts,
            @RequestParam(required = false , defaultValue = "") String postTitle
            ) throws Exception {
        return userService.getUsers(havingMoreThan1Pos, numberOfPosts, postTitle);
    }

    @ExecutionTime
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createUser(@RequestBody UserRequestDto userRequestDto){
        userService.createNewUser(userRequestDto);
    }

    @GetMapping ("/{id}/posts")
    public List<PostDto> getPostFromUserId(@PathVariable long id){
        return userService.getPostFromUserId(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id){
        userService.deleteUser(id);
    }

    @GetMapping("/{id}")
    public UserResponseDto getUserById(@PathVariable long id){
         return userService.findUserFromId(id);
    }
}
