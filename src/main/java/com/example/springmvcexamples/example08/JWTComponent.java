package com.example.springmvcexamples.example08;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.springmvcexamples.example02.handlingexception.exception.MyException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Map;

@Component
public class JWTComponent {
    @Value("my.salt")
    private String secretKey;

    public String encode(Map<String,Object> map){
        LocalDateTime time = LocalDateTime.now().plusSeconds(10);
        return JWT.create()
                .withPayload(map)
                .withIssuedAt(new Date())
                .withExpiresAt(Date.from(time.atZone(ZoneId.systemDefault()).toInstant()))
                .sign(Algorithm.HMAC256(secretKey));
    }




    public DecodedJWT decode(String token){
        try {
            return JWT.require(Algorithm.HMAC256(secretKey)).build().verify(token);
        }catch (TokenExpiredException | SignatureVerificationException e){
            String msg = e instanceof TokenExpiredException ? "过期请重新登陆":"无权限";
            throw new MyException(403,msg);
        }


    }
}
