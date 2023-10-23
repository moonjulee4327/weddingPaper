package com.gaebalgoebal.weddingPaper.domain.board.service;

import com.gaebalgoebal.weddingPaper.domain.board.dto.BoardDescriptionSaveDto;
import com.gaebalgoebal.weddingPaper.domain.board.repository.BoardRepository;
import com.gaebalgoebal.weddingPaper.domain.user.entity.Users;
import com.gaebalgoebal.weddingPaper.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    private final UserRepository userRepository;

    public Long descriptionSave(BoardDescriptionSaveDto boardDescriptionSaveDto){
        Users user = userRepository.findById(boardDescriptionSaveDto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 존재하지 않습니다. id=" + boardDescriptionSaveDto.getUserId()));

        return boardRepository.save(boardDescriptionSaveDto.toEntity(user)).getBoardId();
    }
}
