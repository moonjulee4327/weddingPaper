package com.gaebalgoebal.weddingPaper.domain.board.controller;

import com.gaebalgoebal.weddingPaper.domain.board.dto.BoardDescriptionSaveDto;
import com.gaebalgoebal.weddingPaper.domain.board.service.BoardService;
import com.gaebalgoebal.weddingPaper.domain.user.entity.Users;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Api(tags = "Board API")
@RequestMapping("api/board")
@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardService boardService;

    @Operation(summary = "Save Description and Images", description = "방명록과 이미지를 저장합니다.")
    @ApiResponses(value = {@ApiResponse(responseCode = "success", description = "성공"), @ApiResponse(responseCode = "fail", description = "실패")})
    @PostMapping("/save")
    public Long boardDescriptionSave(@RequestPart(value = "image", required = false) List<MultipartFile> multipartFiles, @RequestPart("data") BoardDescriptionSaveDto boardDescriptionSaveDto){
        return boardService.descriptionSave(boardDescriptionSaveDto, multipartFiles);
    }

    @Operation(summary = "Find all Description and images", description = "저장된 방명록과 이미지 전체를 조회합니다.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "성공"), @ApiResponse(responseCode = "fail", description = "실패")})
    @GetMapping("/boardAllRead")
    public List<Users> boardAllRead(){
        return boardService.boardAllRead();
    }
}
