package com.miu.lab.lab1.repo;

import com.miu.lab.lab1.entity.Post;

import java.util.List;

public interface PostRepo {
    List<Post> getPosts();
    Post getPostById(int id);
    Post createNewPost(Post post);
    Boolean deletePostById(int id);
    Post updatePostById(int id);
}
