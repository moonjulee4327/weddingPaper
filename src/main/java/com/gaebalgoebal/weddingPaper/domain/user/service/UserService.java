package com.gaebalgoebal.weddingPaper.domain.user.service;

import com.gaebalgoebal.weddingPaper.domain.user.dto.UserDrawDto;
import com.gaebalgoebal.weddingPaper.domain.user.dto.UserSaveDto;
import com.gaebalgoebal.weddingPaper.domain.user.entity.Users;
import com.gaebalgoebal.weddingPaper.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Long createUser(UserSaveDto userSaveDto){
        return userRepository.save(userSaveDto.toEntity()).getUserId();
    }

    public String accessUser(UserSaveDto userSaveDto){
        String result = "reject";
        Users users = userSaveDto.toEntity();
        try {
            Users accessUser = userRepository.findByUserNameAndCellPhoneNumber(users.getUserName(), users.getCellPhoneNumber());

            if(accessUser.getUserName().equals("낌스") && accessUser.getCellPhoneNumber().equals("q1w2e3r4")){
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
        List<Users> users = userRepository.findAll();

        List<UserDrawDto> userDrawDtos = users.stream().map(UserDrawDto::new).collect(Collectors.toList());

        for(UserDrawDto s : userDrawDtos){
            System.out.println(s.getUserId());
            System.out.println(s.getUserName());
            System.out.println(s.getCellPhoneNumber());
        }
        return userDrawDtos;
    }
}
