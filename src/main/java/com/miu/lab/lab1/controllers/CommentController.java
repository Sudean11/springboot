package com.miu.lab.lab1.controllers;

import com.miu.lab.lab1.entity.dtos.CommentDto;
import com.miu.lab.lab1.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/posts")
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping("/{id}/comments")
    public void addNewComment(@PathVariable long id, @RequestBody CommentDto commentDto){
        commentService.addNewComment(id, commentDto);
    }

}
