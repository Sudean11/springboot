package com.miu.lab.lab1.controllers;

import com.miu.lab.lab1.entity.DefaultResponse;
import com.miu.lab.lab1.entity.Post;
import com.miu.lab.lab1.entity.dtos.PostDto;
import com.miu.lab.lab1.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class PostController {


    @Autowired
    PostService postService;

    @GetMapping("/posts")
    public List<PostDto> findAllPostWithTitle(@RequestParam String title){
        return postService.getPostWithTitleProvided(title);
    }

    @GetMapping("/{user_id}/posts/{post_id}")
    public PostDto findPostWithId(@PathVariable int user_id, @PathVariable int post_id){
        return postService.findPostFromPostId(user_id, post_id);
    }
}
