package com.miu.lab.lab1.services;

import com.miu.lab.lab1.entity.Post;
import com.miu.lab.lab1.entity.dtos.PostDto;

import java.util.List;

public interface PostService {

    public List<PostDto> getPostWithTitleProvided(String title);

}
