package com.gaebalgoebal.weddingPaper.dto;

import com.gaebalgoebal.weddingPaper.entity.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserSaveDto {

    private String name;

    @Builder
    public UserSaveDto(String name){
        this.name = name;
    }

    public Users toEntity(){
        return Users.builder().name(name).build();
    }

}
