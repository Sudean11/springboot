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
@RequestMapping("/api/v1/posts")
public class PostController {

    @Autowired
    PostService postService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<PostDto> getAll(@RequestParam(value = "author" ,required = false) String author, @RequestParam(value = "text" ,required = false) String text) {
        if (author != null) {
            // Handle author filtering logic
            return postService.findAllPostsByAuthor(author);
        } else if (text != null) {
            // Handle text filtering logic
            return postService.getPostsByAuthorText(text);
        } else {
            // If neither author nor text is present, return all posts
            return postService.getPosts();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable int id){
        Post post = postService.getPostById(id);
        return (post != null) ?
                ResponseEntity.ok(post) :
                ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<DefaultResponse> createNewPost(@RequestBody PostDto postDto){
        if (postService.createNewPost(postDto)) {
            return ResponseEntity.status(HttpStatus.CREATED).body(new DefaultResponse("Success", "Post Created Successfully"));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new DefaultResponse("Failed", "No Post data"));
        }
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable int id){
        postService.deletePostById(id);
    }

    @PutMapping("/{id}")
    public void updatePost(@PathVariable int id, @RequestBody PostDto postDto){
        postService.updatePostById(id, postDto);
    }

}
