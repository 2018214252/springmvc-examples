package com.example.springmvcexamples.example06.service;

import com.example.springmvcexamples.example06.entity.User06;
import org.springframework.stereotype.Service;

@Service
public class UserService06 {
    public User06 getUser(String userName){
        return "QYH".equals(userName)
                ?User06.builder()
                .id(24L)
                .userName("QYH")
                .role("admin")
                .password("$2a$10$vbic.eN8nCmnzExjVIUUwOKsIAz0.NGEYC/IGwjWJHSCC8s37Kn9G")
                .build()
                :null;
    }
}
