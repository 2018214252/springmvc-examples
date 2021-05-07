package com.example.springmvcexamples.example02.handlingexception.controller;

import com.example.springmvcexamples.example02.handlingexception.exception.MyException;
import com.example.springmvcexamples.vo.ResultVO;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController02 {
    @ExceptionHandler(MyException.class)
    public ResultVO handleVaildException(MyException exception){
        return ResultVO.error(exception.getCode(),exception.getMessage());
    }
}
