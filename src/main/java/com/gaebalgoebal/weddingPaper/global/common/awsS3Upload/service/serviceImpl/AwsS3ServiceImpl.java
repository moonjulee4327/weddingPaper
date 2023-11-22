package com.gaebalgoebal.weddingPaper.global.common.awsS3Upload.service.serviceImpl;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.gaebalgoebal.weddingPaper.domain.board.entity.Board;
import com.gaebalgoebal.weddingPaper.global.common.awsS3Upload.entity.AwsS3;
import com.gaebalgoebal.weddingPaper.global.common.awsS3Upload.repository.AwsS3Repository;
import com.gaebalgoebal.weddingPaper.global.common.awsS3Upload.service.AwsS3Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class AwsS3ServiceImpl implements AwsS3Service {

    @Value("${cloud.aws.s3.bucket}")
    private String bucketName;

    private final AmazonS3Client amazonS3Client;

    private final AwsS3Repository awsS3Repository;

    // 테스트 코드 작성해보자!
    @Override
    public String uploadImageTest(MultipartFile multipartFile) {
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentType(multipartFile.getContentType());
        objectMetadata.setContentLength(multipartFile.getSize());

        String fileName = "test1/" + UUID.randomUUID() + "-" + multipartFile.getOriginalFilename();

        try(InputStream inputStream = multipartFile.getInputStream()) {
            amazonS3Client.putObject(bucketName, fileName, inputStream, objectMetadata);
        }catch (IOException e){
            throw new IllegalArgumentException("S3 파일 업로드 실패!");
        }

        String fileUrl = amazonS3Client.getUrl(bucketName, fileName).toString();

        log.info("file url : " + fileUrl);

        return fileUrl;
    }

    public String uploadImage(MultipartFile multipartFile, Board board){
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentType(multipartFile.getContentType());
        objectMetadata.setContentLength(multipartFile.getSize());

        String fileName = "weddingPaperImage/" + UUID.randomUUID() + "-" + multipartFile.getOriginalFilename();

        try(InputStream inputStream = multipartFile.getInputStream()) {
            amazonS3Client.putObject(bucketName, fileName, inputStream, objectMetadata);
        }catch (IOException e){
            throw new IllegalArgumentException("S3 파일 업로드 실패!");
        }

        String fileUrl = amazonS3Client.getUrl(bucketName, fileName).toString();

        AwsS3 awsS3 = AwsS3.builder()
                .board(board)
                .url(fileUrl)
                .originalName(multipartFile.getOriginalFilename())
                .storedName(fileName).build();

        awsS3Repository.save(awsS3);

        log.info("file url : " + fileUrl);

        return fileUrl;
    }

}
