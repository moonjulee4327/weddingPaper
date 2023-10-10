package com.gaebalgoebal.weddingPaper.controller;

import com.gaebalgoebal.weddingPaper.dto.UserSaveDto;
import com.gaebalgoebal.weddingPaper.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RequestMapping("api/user")
@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public Long createUser(@RequestBody UserSaveDto userSaveDto) {
        return userService.createUser(userSaveDto);
    }

}
