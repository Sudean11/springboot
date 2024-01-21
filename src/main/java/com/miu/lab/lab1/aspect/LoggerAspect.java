package com.miu.lab.lab1.aspect;

import com.miu.lab.lab1.entity.Logger;
import com.miu.lab.lab1.repo.LoggerRepo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
@Aspect
@Component
public class LoggerAspect {
    @Autowired
    LoggerRepo loggerRepo;
    @Pointcut("execution(public * com.miu.lab.lab1.controllers.*.*(..))")
    public void logOperations()
    {

    }
    @After("logOperations()")
    public void  saveAllExecutedOperations(JoinPoint joinPoint)
    {
        Logger logger=new Logger();
        logger.setDate(LocalDate.now());
        logger.setTime(LocalTime.now());
        logger.setPrinciple("Static User");
        logger.setOperation(String.valueOf(joinPoint.getSignature()));
        loggerRepo.save(logger);
    }
}
