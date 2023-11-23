package com.gaebalgoebal.weddingPaper.domain.user.dto;

import com.gaebalgoebal.weddingPaper.domain.user.entity.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserDrawDto {

    private Long userId;

    private String userName;

    private String cellPhoneNumber;

    @Builder
    public UserDrawDto(Users users){
        this.userId = users.getUserId();
        this.userName = users.getUserName();
        this.cellPhoneNumber = users.getCellPhoneNumber();
    }

}
