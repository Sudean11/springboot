package com.miu.lab.lab1.repo;

import com.miu.lab.lab1.entity.Comment;
import com.miu.lab.lab1.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepo extends JpaRepository<Comment, Long> {

    List<Comment> findAllByPost(Post post);

}
