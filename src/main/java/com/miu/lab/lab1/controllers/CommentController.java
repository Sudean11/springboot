package com.miu.lab.lab1.controllers;

import com.miu.lab.lab1.ExceptionHandler.SpringExceptionHandler;
import com.miu.lab.lab1.entity.dtos.CommentDto;
import com.miu.lab.lab1.entity.dtos.ErrorResponseDto;
import com.miu.lab.lab1.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> findCommentFromCommentId(@PathVariable long user_id, @PathVariable long post_id, @PathVariable long comment_id){
        try {
            return ResponseEntity.ok(commentService.findCommentsFromPostId(user_id, post_id, comment_id));
        } catch (SpringExceptionHandler e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponseDto(e.getMessage()));
        }
    }

}
