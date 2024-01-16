package com.miu.lab.lab1.services;

import com.miu.lab.lab1.entity.Post;

import java.util.List;

public interface PostService {
    List<Post> getPosts();
    Post getPostById(int id);
    Post createNewPost(Post post);
    Boolean deletePostById(int id);
    Post updatePostById(int id);
}
