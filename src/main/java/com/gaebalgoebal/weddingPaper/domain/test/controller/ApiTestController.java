package com.gaebalgoebal.weddingPaper.domain.test.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "API TEST")
@RestController
public class ApiTestController {

    @ApiOperation(value = "연동 및 CORS 테스트", notes = "React와 Spring boot 서버 연동을 테스트한다.")
    @GetMapping("/apiTest")
    public String getHelloWorld(){
        return "Hello World";
    }

}
