package com.example.springmvcexamples.example03.controller;

import com.example.springmvcexamples.vo.ResultVO;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

@RestControllerAdvice
public class ExceptionController03 {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultVO handleValidException(MethodArgumentNotValidException exception){
        StringBuilder stringBuilder = new StringBuilder();
        exception.getBindingResult()
                .getFieldErrors()
                .forEach(e->{
                    stringBuilder.append(e.getField());
                    stringBuilder.append(":");
                    stringBuilder.append(e.getDefaultMessage());
                    stringBuilder.append(";");
                });
        return ResultVO.error(400,stringBuilder.toString());
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResultVO handleMethodArgumentTypeMismatchException(
            MethodArgumentTypeMismatchException exception,
            HttpServletRequest request){
        String msg = request.getRequestURI()+":"+"请求地址参数"+ exception.getValue()+"错误";
        return ResultVO.error(400,msg);
    }

    @ExceptionHandler(InvalidFormatException.class)
    public ResultVO handleInvalidFormatException(InvalidFormatException exception){
        StringBuilder stringBuilder = new StringBuilder();
        exception.getPath()
                .forEach(e->{
                    stringBuilder.append("属性")
                            .append(e.getFieldName())
                            .append(",您输入的值为")
                            .append(exception.getValue())
                            .append(",类型错误！");
                });
        return ResultVO.error(400,stringBuilder.toString());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResultVO handleConstraintViolationException(ConstraintViolationException exception){
        StringBuilder stringBuilder = new StringBuilder();
        Set<ConstraintViolation<?>> violations = exception.getConstraintViolations();
        violations.forEach(v->stringBuilder.append(v.getMessage()).append(";"));
        return ResultVO.error(400,stringBuilder.toString());
    }
}
