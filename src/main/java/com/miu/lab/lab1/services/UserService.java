package com.miu.lab.lab1.services;

import com.miu.lab.lab1.entity.dtos.PostDto;
import com.miu.lab.lab1.entity.dtos.requestDto.UserRequestDto;
import com.miu.lab.lab1.entity.dtos.responseDto.UserResponseDto;

import java.util.List;


public interface UserService {

    List<UserResponseDto> getUsers(boolean havingMoreThanOnePost, int n, String postTitle) throws Exception;
    List<UserResponseDto> getUsersWithMoreThanOnePost();
    UserResponseDto findUserFromId(long userId);
    void createNewUser(UserRequestDto user);
    List<PostDto> getPostFromUserId(Long userId);
    void deleteUser(long id);
    List<UserResponseDto> findAllByPostTitle(String title);
}
