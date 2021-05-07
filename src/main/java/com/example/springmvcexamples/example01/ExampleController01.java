package com.example.springmvcexamples.example01;

import com.example.springmvcexamples.example01.entity.Address;
import com.example.springmvcexamples.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/example01/")
public class ExampleController01 {
    @GetMapping("index")
    public ResultVO getIndex(){
        return ResultVO.success(Map.of("name","SUN"));
    }

    @GetMapping("addresses")
    public ResultVO getAddresses(){
        return ResultVO.success(Map.of("addresses",ADDRESSES));
    }

    @GetMapping("inject")
    public void inject(HttpServletRequest request,
                       HttpServletResponse response,
                       @RequestHeader HttpHeaders headers){
        log.debug((request.getRequestURI()));
        log.debug(String.valueOf(headers));
    }


    private final List<Address> ADDRESSES = create();

    private List<Address> create() {
        Address a1 = new Address(1, "956", "a", LocalDateTime.now());
        Address a2 = new Address(2, "925", "b", LocalDateTime.now());
        Address a3 = new Address(3, "121", null, null);
        return List.of(a1, a2, a3);
    }

}
