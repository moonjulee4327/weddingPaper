package com.gaebalgoebal.weddingPaper.domain.board.controller;

import com.gaebalgoebal.weddingPaper.domain.board.dto.BoardDescriptionSaveDto;
import com.gaebalgoebal.weddingPaper.domain.board.service.BoardService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Board API")
@RequestMapping("api/board")
@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardService boardService;

    @Operation(summary = "Save Description", description = "배영호를 저장합니다.")
    @ApiResponses(value = {@ApiResponse(responseCode = "success", description = "성공"), @ApiResponse(responseCode = "fail")})
    @PostMapping("/save")
    public Long boardDescriptionSave(@RequestBody BoardDescriptionSaveDto boardDescriptionSaveDto){
        return boardService.descriptionSave(boardDescriptionSaveDto);
    }

}
