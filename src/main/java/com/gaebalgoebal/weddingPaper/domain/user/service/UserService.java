package com.gaebalgoebal.weddingPaper.domain.user.service;

import com.gaebalgoebal.weddingPaper.domain.user.dto.UserDrawDto;
import com.gaebalgoebal.weddingPaper.domain.user.dto.UserSaveDto;
import com.gaebalgoebal.weddingPaper.domain.user.entity.Users;
import com.gaebalgoebal.weddingPaper.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Value("${admin.name}")
    private String adminName;

    @Value("${admin.password}")
    private String adminPassword;

    public Long createUser(UserSaveDto userSaveDto){
        return userRepository.save(userSaveDto.toEntity()).getUserId();
    }

    public String accessUser(UserSaveDto userSaveDto){
        String result = "reject";
        Users users = userSaveDto.toEntity();
        try {
            Users accessUser = userRepository.findByUserNameAndCellPhoneNumber(users.getUserName(), users.getCellPhoneNumber());
            if(accessUser.getUserName().equals(adminName) && accessUser.getCellPhoneNumber().equals(adminPassword)){
                result = "jh";
            }else {
                return result;
            }
        }catch (Exception e){
            result = "unknwon";
            return result;
        }
        return result;
    }

    public List<UserDrawDto> drawUserRead(){
        return userRepository.findDistinctUsers();
    }
}
