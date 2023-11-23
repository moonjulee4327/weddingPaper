package com.gaebalgoebal.weddingPaper.domain.user.controller;

import com.gaebalgoebal.weddingPaper.domain.user.dto.UserDrawDto;
import com.gaebalgoebal.weddingPaper.domain.user.dto.UserSaveDto;
import com.gaebalgoebal.weddingPaper.domain.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(tags = "User API")
@RequestMapping("api/user")
@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @Operation(summary = "Create User", description = "유저를 생성합니다.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "성공"), @ApiResponse(responseCode = "fail")})
    @PostMapping("/create")
    public Long createUser(@RequestBody UserSaveDto userSaveDto) {
        return userService.createUser(userSaveDto);
    }

    @Operation(summary = "Access User", description = "신랑, 신부 페이지 접근을 허용합니다.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "성공 (return jh)"), @ApiResponse(responseCode = "fail")})
    @PostMapping("/access")
    public String accessUser(@RequestBody UserSaveDto userSaveDto){
        return userService.accessUser(userSaveDto);
    }

    @Operation(summary = "Draw All User Select", description = "신랑, 신부 페이지에서 경품 룰렛 화면을 조회합니다.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "성공"), @ApiResponse(responseCode = "fail")})
    @GetMapping("/drawUserRead")
    public List<UserDrawDto> drawUserRead(){
        return userService.drawUserRead();
    }

}
