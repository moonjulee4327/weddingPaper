package com.gaebalgoebal.weddingPaper.domain.test.controller;

import com.gaebalgoebal.weddingPaper.global.common.AwsS3Service;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RequiredArgsConstructor
@Api(tags = "API TEST")
@RestController
public class ApiTestController {

    private final AwsS3Service awsS3Service;

    @ApiOperation(value = "연동 및 CORS 테스트", notes = "React와 Spring boot 서버 연동을 테스트한다.")
    @GetMapping("/apiTest")
    public String getHelloWorld(){
        log.info("테스트");
        return "Hello World";
    }

    @ApiOperation(value = "이미지 업로드 테스트", notes = "aws S3를 통해 이미지를 업로드합니다.")
    @PostMapping("/imageTest")
    public String uploadImageTest(@RequestParam("images") MultipartFile[] multipartFiles){
        for(MultipartFile multipartFile : multipartFiles){
            awsS3Service.uploadImage(multipartFile);
        }
        return "업로드 성공";
    }

}
