package com.gaebalgoebal.weddingPaper.domain.board.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class BoardImagesAllReadDto {

    private Long userId;

    private String userName;

    private String description;

    private List<String> url;

    @Builder
    public BoardImagesAllReadDto(Long userId, String userName, String description, List<String> url){
        this.userId = userId;
        this.userName = userName;
        this.description = description;
        this.url = url;
    }

}
