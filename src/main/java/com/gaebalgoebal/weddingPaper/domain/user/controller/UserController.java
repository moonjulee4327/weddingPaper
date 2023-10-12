package com.gaebalgoebal.weddingPaper.domain.user.controller;

import com.gaebalgoebal.weddingPaper.domain.user.dto.UserSaveDto;
import com.gaebalgoebal.weddingPaper.domain.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(tags = "User API")
@RequestMapping("api/user")
@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @Operation(summary = "Create User", description = "유저를 생성합니다.")
    @ApiResponses(value = {@ApiResponse(responseCode = "success", description = "성공"), @ApiResponse(responseCode = "fail")})
    @PostMapping("/create")
    public Long createUser(@RequestBody UserSaveDto userSaveDto) {
        return userService.createUser(userSaveDto);
    }

}
