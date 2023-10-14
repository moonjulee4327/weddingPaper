package com.gaebalgoebal.weddingPaper.domain.user.service;

import com.gaebalgoebal.weddingPaper.domain.user.dto.UserSaveDto;
import com.gaebalgoebal.weddingPaper.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
