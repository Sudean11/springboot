package com.miu.lab.lab1.repo;

import com.miu.lab.lab1.entity.Post;
import com.miu.lab.lab1.entity.dtos.PostDto;

import java.util.List;

public interface PostRepo {
    List<Post> getPosts();
    Post getPostById(int id);
    void createNewPost(Post post);
    void deletePostById(int id);
    void updatePostById(int id, Post post);
    List<Post> findAllPostsByAuthor(String author);
    List<Post> getPostsByAuthorText(String text);
}
