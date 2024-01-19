package com.miu.lab.lab1.services;

import com.miu.lab.lab1.entity.dtos.CommentDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface CommentService {

    public void addNewComment(long postId, CommentDto commentDto);

    List<CommentDto> findCommentsFromPostId(long user_id,long post_id);

    CommentDto findCommentsFromPostId(long user_id, long post_id, long comment_id);
}


