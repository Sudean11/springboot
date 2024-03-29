package com.miu.lab.lab1.repo;

import com.miu.lab.lab1.entity.Post;
import com.miu.lab.lab1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    @Query("Select u from User u where size(u.posts) > 1")
    List<User> findAllByPostCountGreaterThanOne();

    @Query("Select u from User u where size(u.posts) > :n")
    List<User> findAllByPostCountGreaterThanN(int n);
    @Query("Select u from User u Join u.posts p where p.title = :title")
    List<User> findAllByPostsTitle(String title);

}
