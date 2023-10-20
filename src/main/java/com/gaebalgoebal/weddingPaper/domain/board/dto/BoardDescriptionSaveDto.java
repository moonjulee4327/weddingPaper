package com.gaebalgoebal.weddingPaper.domain.board.dto;

import com.gaebalgoebal.weddingPaper.domain.board.entity.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardDescriptionSaveDto {

    private String description;

    @Builder
    public BoardDescriptionSaveDto(String description){
        this.description = description;
    }

    public Board toEntity(){
        return Board.builder().description(description).build();
    }

}
