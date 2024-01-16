package com.miu.lab.lab1.services.serviceImpl;

import com.miu.lab.lab1.entity.Post;
import com.miu.lab.lab1.repo.PostRepo;
import com.miu.lab.lab1.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepo postRepo;

    @Override
    public List<Post> getPosts() {
        return postRepo.getPosts();
    }

    @Override
    public Post getPostById(int id) {
        return postRepo.getPostById(id);
    }

    @Override
    public Post createNewPost(Post post) {
        return null;
    }

    @Override
    public Boolean deletePostById(int id) {
        return null;
    }

    @Override
    public Post updatePostById(int id) {
        return null;
    }
}
