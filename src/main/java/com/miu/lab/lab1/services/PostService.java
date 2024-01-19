package com.miu.lab.lab1.services;

import com.miu.lab.lab1.entity.Post;
import com.miu.lab.lab1.entity.dtos.PostDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface PostService {

    public List<PostDto> getPostWithTitleProvided(String title);

     List<PostDto> getPostsOfUser(long user_id);

    PostDto findPostFromPostId(long user_id, long post_id);

}
