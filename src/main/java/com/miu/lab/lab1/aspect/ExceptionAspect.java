package com.miu.lab.lab1.aspect;

import com.miu.lab.lab1.entity.ExceptionModel;
import com.miu.lab.lab1.repo.ExceptionRepo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Aspect
@Component
public class ExceptionAspect {
    @Autowired
    ExceptionRepo exceptionRepo;

    @AfterThrowing(pointcut = "execution(* com.miu.lab.lab1.controllers.*.*(..))", throwing = "exception")
    public void logException(JoinPoint joinPoint, Exception exception){
        String principle = "User"; // Your fake static user
        String operation = joinPoint.getSignature().toShortString();

        ExceptionModel exceptionEntity = new ExceptionModel();
        exceptionEntity.setDate(LocalDate.now());
        exceptionEntity.setPrinciple(principle);
        exceptionEntity.setOperation(operation);
        exceptionEntity.setTime(LocalTime.now());
        exceptionEntity.setType(exception.getClass().getName());

        exceptionRepo.save(exceptionEntity);
    }
}
