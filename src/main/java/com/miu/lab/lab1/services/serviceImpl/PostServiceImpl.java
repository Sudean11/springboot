package com.miu.lab.lab1.services.serviceImpl;

import com.miu.lab.lab1.entity.dtos.PostDto;
import com.miu.lab.lab1.helper.ListMapper;
import com.miu.lab.lab1.repo.PostRepo;
import com.miu.lab.lab1.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostRepo postRepo;

    @Autowired
    ListMapper listMapper;

    @Override
    public List<PostDto> getPostWithTitleProvided(String title) {
        return (List<PostDto>)listMapper.mapList(postRepo.findPostsByTitle(title), new PostDto());
    }
}
