package com.miu.lab.lab1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class PostController {

    @GetMapping
    public String root(){
        return "hello";
    }
}
