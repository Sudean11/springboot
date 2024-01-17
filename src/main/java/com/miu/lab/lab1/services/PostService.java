package com.miu.lab.lab1.services;

import com.miu.lab.lab1.entity.Post;
import com.miu.lab.lab1.entity.dtos.PostDto;

import java.util.List;

public interface PostService {
    List<PostDto> getPosts();
    Post getPostById(int id);
    Boolean createNewPost(PostDto postDto);
    void deletePostById(int id);
    void updatePostById(int id, PostDto postDto);
    List<PostDto> findAllPostsByAuthor(String author);

    List<PostDto> getPostsByAuthorText(String text);
}
