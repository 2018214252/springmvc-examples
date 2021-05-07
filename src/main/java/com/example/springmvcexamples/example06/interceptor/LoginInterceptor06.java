package com.example.springmvcexamples.example06.interceptor;

import com.example.springmvcexamples.example02.handlingexception.exception.MyException;
import com.example.springmvcexamples.example05.EncryptCompoment05;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component
@Slf4j
public class LoginInterceptor06 implements HandlerInterceptor {
    @Autowired
    private EncryptCompoment05 encryptCompoment;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handle){
        String token = request.getHeader("token");
        if(token == null){
            throw new MyException(401,"未登录");
        }
        Map<String,Object>result = encryptCompoment.decrypt(token);
        request.setAttribute("role",result.get("role"));
        return true;
    }
}
