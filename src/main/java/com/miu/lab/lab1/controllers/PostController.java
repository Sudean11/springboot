package com.miu.lab.lab1.controllers;

import com.miu.lab.lab1.entity.DefaultResponse;
import com.miu.lab.lab1.entity.Post;
import com.miu.lab.lab1.entity.dtos.PostDto;
import com.miu.lab.lab1.repo.PostRepo;
import com.miu.lab.lab1.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {

    @Autowired
    PostService postService;

    @Autowired
    PostRepo postRepo;

    @GetMapping()
    public List<?> findAllPostWithTitle(@RequestParam(required = false) String title ){
        if(title==null){
         return postRepo.findAll();
        }
        return postService.getPostWithTitleProvided(title);
    }

    @Autowired
    ModelMapper modelMapper;



    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id){
        postRepo.deleteById(id);
    }

    @GetMapping("/{id}")
    public Post findById(@PathVariable long id){
        return postRepo.findById(id).get();
    }

//    @GetMapping("/{user_id}/posts/{post_id}")
//    public PostDto findPostWithId(@PathVariable int user_id, @PathVariable int post_id){
//        return postService.findPostFromPostId(user_id, post_id);
//    }



}
