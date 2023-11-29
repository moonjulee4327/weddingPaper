package com.gaebalgoebal.weddingPaper.global.common.awsS3Upload.entity;

import com.gaebalgoebal.weddingPaper.domain.board.entity.Board;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "photo")
@Entity
public class AwsS3 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fileId;

    @ManyToOne
    @JoinColumn(name = "board_id", nullable = false)
    private Board board;

    @Column(columnDefinition = "TEXT")
    private String url;

    @Column(name = "original_name", length = 512)
    private String originalName;

    @Column(name = "stored_name", length = 512)
    private String storedName;

    @Builder
    public AwsS3(Board board, String url, String originalName, String storedName){
        this.board = board;
        this.url = url;
        this.originalName = originalName;
        this.storedName = storedName;
    }

}
