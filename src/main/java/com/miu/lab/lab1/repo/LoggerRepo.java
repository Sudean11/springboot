package com.miu.lab.lab1.repo;

import com.miu.lab.lab1.entity.Logger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoggerRepo extends JpaRepository<Logger, Integer> {
}
