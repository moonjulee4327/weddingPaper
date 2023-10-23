package com.gaebalgoebal.weddingPaper.domain.board.dto;

import com.gaebalgoebal.weddingPaper.domain.board.entity.Board;
import com.gaebalgoebal.weddingPaper.domain.user.entity.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardDescriptionSaveDto {

    private Long userId;

    private String description;

    @Builder
    public BoardDescriptionSaveDto(Long userId, String description){
        this.userId = userId;
        this.description = description;
    }

    public Board toEntity(Users users){
        return Board.builder().users(users).description(description).build();
    }

}
