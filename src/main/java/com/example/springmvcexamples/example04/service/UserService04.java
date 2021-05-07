package com.example.springmvcexamples.example04.service;

import com.example.springmvcexamples.example04.entity.User04;
import org.springframework.stereotype.Service;

@Service
public class UserService04 {
    public User04 getUser(String userName){
        return "QYH".equals(userName)
                ?User04.builder()
                .userName("QYH")
                .password("$2a$10$vbic.eN8nCmnzExjVIUUwOKsIAz0.NGEYC/IGwjWJHSCC8s37Kn9G")
                .build()
                :null;
    }
}
