package com.miu.lab.lab1.repo;

import com.miu.lab.lab1.entity.ExceptionModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExceptionRepo extends JpaRepository<ExceptionModel, Integer> {
}
