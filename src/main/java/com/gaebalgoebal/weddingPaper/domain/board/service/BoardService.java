package com.gaebalgoebal.weddingPaper.domain.board.service;

import com.gaebalgoebal.weddingPaper.domain.board.dto.BoardDescriptionSaveDto;
import com.gaebalgoebal.weddingPaper.domain.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public Long descriptionSave(BoardDescriptionSaveDto boardDescriptionSaveDto){
        return boardRepository.save(boardDescriptionSaveDto.toEntity()).getBoardId();
    }
}
