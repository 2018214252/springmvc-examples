package com.example.springmvcexamples.example03.controller;

import com.example.springmvcexamples.example03.entity.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;

@RestController
@RequestMapping("/api/example03/")
@Validated
public class ExampleController03 {
    @PostMapping("users")
    public void postUser(@Valid @RequestBody User user){
    }

    @GetMapping("/users/{uid}/file")
    public void get(@PathVariable int uid){
    }

    @GetMapping("/users/{onwer}")
    public void getViolateException(@Size(min = 2, max = 6, message = "用户信息错误") @PathVariable String onwer){
    }
}
