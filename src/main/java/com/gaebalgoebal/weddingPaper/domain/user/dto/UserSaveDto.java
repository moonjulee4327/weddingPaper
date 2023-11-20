package com.gaebalgoebal.weddingPaper.domain.user.dto;

import com.gaebalgoebal.weddingPaper.domain.user.entity.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserSaveDto {

    private String userName;

    private String cellPhoneNumber;

    @Builder
    public UserSaveDto(String userName, String cellPhoneNumber){
        this.userName = userName;
        this.cellPhoneNumber = cellPhoneNumber;
    }

    public Users toEntity(){
        return Users.builder().userName(userName).cellPhoneNumber(cellPhoneNumber).build();
    }

}
