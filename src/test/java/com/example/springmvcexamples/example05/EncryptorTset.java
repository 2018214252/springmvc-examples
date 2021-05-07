package com.example.springmvcexamples.example05;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
@Slf4j
public class EncryptorTset {
    @Autowired
    private EncryptCompoment05 encrypt;
    @Test
    public void test_encrypt(){
        Map<String,Object> map = Map.of("uid",12346789123456789L,"role",9);
        String r = encrypt.encrypt(map);
        log.debug(r);
        log.debug(encrypt.encrypt(map));
    }

    @Test
    public void test_decrypt(){
        String auth="36db0cf7cbe72c7e9d2579a5d0328d0ad9f255427f81095f903ac1c31262e39365eb40609c20a52261d640f659722e4ab95b9717c7339d668b06ea2d23ed0716";
        Map<String,Object>token = encrypt.decrypt(auth);
        token.forEach((k,v)->{
            log.debug(k+":"+v);
        });
    }
}
