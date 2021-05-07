package com.example.springmvcexamples.example08;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
@Slf4j
public class JWTTest {
    @Autowired
    private JWTComponent jwtComponent;
    @Test
    public void test() throws InterruptedException {
        String token =jwtComponent.encode(Map.of("uid",123456789123456789L,"role",9));
        log.debug(token);
        long uid = jwtComponent.decode(token).getClaim("uid").asLong();
        log.debug(String.valueOf(uid));
        Thread.sleep(15000);
        long uid2 = jwtComponent.decode(token).getClaim("uid").asLong();
        log.debug(String.valueOf(uid2));
    }
}
