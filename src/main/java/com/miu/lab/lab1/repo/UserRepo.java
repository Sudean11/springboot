package com.miu.lab.lab1.repo;

import com.miu.lab.lab1.entity.Post;
import com.miu.lab.lab1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

}
