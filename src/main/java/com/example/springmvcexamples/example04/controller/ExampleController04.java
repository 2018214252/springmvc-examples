package com.example.springmvcexamples.example04.controller;

import com.example.springmvcexamples.example04.entity.User04;
import com.example.springmvcexamples.example04.service.UserService04;
import com.example.springmvcexamples.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/example04/")
@Slf4j
public class ExampleController04 {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserService04 userService;

    @PostMapping("login")
    public ResultVO login(@RequestBody User04 user04){
        User04 u = userService.getUser(user04.getUserName());
        if(u == null || !passwordEncoder.matches(user04.getPassword(),u.getPassword())){
            log.debug("登陆失败");
            return ResultVO.error(401,"用户密码错误");
        }
        log.debug("登陆成功");
        return ResultVO.success(Map.of("user",u));
    }
}
