package com.gaebalgoebal.weddingPaper.service;

import com.gaebalgoebal.weddingPaper.dto.UserSaveDto;
import com.gaebalgoebal.weddingPaper.entity.Users;
import com.gaebalgoebal.weddingPaper.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Long createUser(UserSaveDto userSaveDto){
        return userRepository.save(userSaveDto.toEntity()).getId();
    }

}
