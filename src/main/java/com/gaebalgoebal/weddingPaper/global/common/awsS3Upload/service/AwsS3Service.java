package com.gaebalgoebal.weddingPaper.global.common.awsS3Upload.service;

import com.gaebalgoebal.weddingPaper.domain.board.entity.Board;
import org.springframework.web.multipart.MultipartFile;

public interface AwsS3Service {

    public String uploadImageTest(MultipartFile multipartFile);

    public String uploadImage(MultipartFile multipartFile, Board board);

}
