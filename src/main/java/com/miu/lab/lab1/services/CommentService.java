package com.miu.lab.lab1.services;

import com.miu.lab.lab1.entity.dtos.CommentDto;

public interface CommentService {

    public void addNewComment(long postId, CommentDto commentDto);

}
