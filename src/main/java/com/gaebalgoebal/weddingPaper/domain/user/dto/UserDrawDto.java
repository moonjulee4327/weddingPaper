package com.gaebalgoebal.weddingPaper.domain.user.dto;

import com.gaebalgoebal.weddingPaper.domain.user.entity.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class UserDrawDto {

    private String userName;

    private String cellPhoneNumber;

    @Builder
    public UserDrawDto(String userName, String cellPhoneNumber){
        this.userName = userName;
        this.cellPhoneNumber = cellPhoneNumber;
    }

}
