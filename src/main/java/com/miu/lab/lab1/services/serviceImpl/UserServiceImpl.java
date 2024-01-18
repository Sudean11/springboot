package com.miu.lab.lab1.services.serviceImpl;

import com.miu.lab.lab1.entity.Post;
import com.miu.lab.lab1.entity.User;
import com.miu.lab.lab1.entity.dtos.PostDto;
import com.miu.lab.lab1.entity.dtos.requestDto.UserRequestDto;
import com.miu.lab.lab1.entity.dtos.responseDto.UserResponseDto;
import com.miu.lab.lab1.helper.ListMapper;
import com.miu.lab.lab1.repo.UserRepo;
import com.miu.lab.lab1.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ListMapper listMapper;

    @Override
    public List<UserResponseDto> getUsers() {
        return (List<UserResponseDto>) listMapper.mapList(userRepo.findAll(), new UserResponseDto());
    }

    @Override
    public List<UserResponseDto> getUsersWithMoreThanOnePost() {
        return null;
    }

    @Override
    public UserResponseDto findUserFromId(long userId) {
        return null;
    }

    @Override
    public void createNewUser(UserRequestDto user) {
        User a = modelMapper.map(user, User.class);
        List<Post> postList = (List<Post>)listMapper.mapList(user.getPosts(), new Post());
        a.setPosts(postList);
        userRepo.save(a);
    }

    @Override
    public List<PostDto> getPostFromUserId(Long userId) {
        List<Post> posts =  userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User Not Found"))
                .getPosts();
        return listMapper.mapList(posts, new PostDto());
    }
}
