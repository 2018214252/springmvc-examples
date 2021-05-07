package com.example.springmvcexamples.example06.controller;

import com.example.springmvcexamples.example05.EncryptCompoment05;
import com.example.springmvcexamples.example06.entity.User06;
import com.example.springmvcexamples.example06.service.UserService06;
import com.example.springmvcexamples.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/example06/")
public class ExampleController06 {
    @Autowired
    public UserService06 userService;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private EncryptCompoment05 encryptCompoment;

    @PostMapping("login")
    public ResultVO login(@RequestBody User06 user, HttpServletResponse response){
        User06 u = userService.getUser(user.getUserName());
        if(u == null || !encoder.matches(user.getPassword(), u.getPassword())){
            return ResultVO.error(401,"用户名密码错误");
        }
        String result = encryptCompoment.encrypt(Map.of("uid",u.getId(),"role",u.getRole()));
        log.debug(result);
        response.addHeader("token",result);
        return ResultVO.success(Map.of());
    }

    @GetMapping("admin/welcome")
    public ResultVO getWelcome(@RequestAttribute("role") String role){
        log.debug(role);
        return ResultVO.success(Map.of("msg","欢迎回来"));
    }

}
