package com.miu.lab.lab1.services.serviceImpl;

import com.miu.lab.lab1.entity.Comment;
import com.miu.lab.lab1.entity.dtos.CommentDto;
import com.miu.lab.lab1.repo.CommentRepo;
import com.miu.lab.lab1.repo.PostRepo;
import com.miu.lab.lab1.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepo commentRepo;

    @Autowired
    PostRepo postRepo;

    @Override
    public void addNewComment(long postId, CommentDto commentDto) {
        Comment comment = new Comment();
        comment.setName(commentDto.getName());
        comment.setPost(postRepo.findById(postId).orElse(null));
        if(comment.getPost() != null){
            commentRepo.save(comment);
        }
    }
}
