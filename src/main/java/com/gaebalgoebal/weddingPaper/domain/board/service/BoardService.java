package com.gaebalgoebal.weddingPaper.domain.board.service;

import com.gaebalgoebal.weddingPaper.domain.board.dto.BoardDescriptionSaveDto;
import com.gaebalgoebal.weddingPaper.domain.board.dto.BoardImagesAllReadDto;
import com.gaebalgoebal.weddingPaper.domain.board.entity.Board;
import com.gaebalgoebal.weddingPaper.domain.board.repository.BoardRepository;
import com.gaebalgoebal.weddingPaper.domain.user.entity.Users;
import com.gaebalgoebal.weddingPaper.domain.user.repository.UserRepository;
import com.gaebalgoebal.weddingPaper.global.common.awsS3Upload.entity.AwsS3;
import com.gaebalgoebal.weddingPaper.global.common.awsS3Upload.service.serviceImpl.AwsS3ServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    private final UserRepository userRepository;

    private final AwsS3ServiceImpl awsS3ServiceImpl;

    public Long descriptionSave(BoardDescriptionSaveDto boardDescriptionSaveDto, List<MultipartFile> multipartFiles){
        Users user = userRepository.findById(boardDescriptionSaveDto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 존재하지 않습니다. id=" + boardDescriptionSaveDto.getUserId()));

        Board board = boardRepository.save(boardDescriptionSaveDto.toEntity(user));

        if(multipartFiles != null){
            for(MultipartFile multipartFile : multipartFiles){
                awsS3ServiceImpl.uploadImage(multipartFile, board);
            }
        }

        return board.getBoardId();
    }

    public List<Users> boardAllRead(){
        return userRepository.findAll();
    }
}
