package com.miu.lab.lab1.repo;

import com.miu.lab.lab1.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Long> {
}
