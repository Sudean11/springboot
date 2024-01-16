package com.miu.lab.lab1.controllers;

import com.miu.lab.lab1.entity.Post;
import com.miu.lab.lab1.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping
    public List<Post> getAllPosts(){
        return postService.getPosts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable int id){
        Post post = postService.getPostById(id);
        return (post != null) ?
                ResponseEntity.ok(post) :
                ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }



}
