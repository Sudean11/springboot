package com.miu.lab.lab1.controllers;

import com.miu.lab.lab1.entity.dtos.CommentDto;
import com.miu.lab.lab1.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping("{user_id}/posts/{id}/comments")
    public void addNewComment(@PathVariable long id, @RequestBody CommentDto commentDto){
        commentService.addNewComment(id, commentDto);
    }
    @GetMapping("/{user_id}/posts/{post_id}/comments")
    public List<CommentDto> findCommentsFromPostId(@PathVariable long user_id, @PathVariable long post_id){
        return commentService.findCommentsFromPostId(user_id, post_id);
    }
    @GetMapping("/{user_id}/posts/{post_id}/comments/{comment_id}")
    public CommentDto findCommentFromCommentId(@PathVariable long user_id, @PathVariable long post_id, @PathVariable long comment_id){
        return commentService.findCommentsFromPostId(user_id, post_id, comment_id);
    }

}
