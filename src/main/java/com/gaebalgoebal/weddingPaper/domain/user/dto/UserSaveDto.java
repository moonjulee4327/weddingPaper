package com.gaebalgoebal.weddingPaper.domain.user.dto;

import com.gaebalgoebal.weddingPaper.domain.user.entity.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserSaveDto {

    private String userName;

    @Builder
    public UserSaveDto(String userName){
        this.userName = userName;
    }

    public Users toEntity(){
        return Users.builder().userName(userName).build();
    }

}
