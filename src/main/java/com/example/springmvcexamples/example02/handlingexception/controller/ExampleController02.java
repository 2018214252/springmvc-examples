package com.example.springmvcexamples.example02.handlingexception.controller;

import com.example.springmvcexamples.example02.handlingexception.service.UserService02;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/api/example02/")
public class ExampleController02 {
    @Autowired
    private UserService02 userService02;

    @GetMapping("exception")
    public void getException(){
        userService02.readFile();
    }
}
