package com.miu.lab.lab1.services.serviceImpl;

import com.miu.lab.lab1.entity.Post;
import com.miu.lab.lab1.entity.dtos.PostDto;
import com.miu.lab.lab1.helper.ListMapper;
import com.miu.lab.lab1.repo.PostRepo;
import com.miu.lab.lab1.repo.UserRepo;
import com.miu.lab.lab1.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostRepo postRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    ListMapper listMapper;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<PostDto> getPostWithTitleProvided(String title) {
        return (List<PostDto>)listMapper.mapList(postRepo.findPostsByTitle(title), new PostDto());
    }
    @Override
    public List<PostDto> getPostsOfUser(long user_id) {
        return (List<PostDto>) listMapper.mapList(userRepo.findById(user_id).get().getPosts(), new PostDto());
    }
    @Override
    public PostDto findPostFromPostId(long user_id, long post_id) {
        Post post = postRepo.findById(post_id).orElse(null);
        if(post != null){
            return modelMapper.map(post, PostDto.class);
        }
        return null;
    }
}
