package com.gaebalgoebal.weddingPaper.domain.board.entity;

import com.gaebalgoebal.weddingPaper.domain.user.entity.Users;
import com.gaebalgoebal.weddingPaper.global.common.awsS3Upload.entity.AwsS3;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users users;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    @CreationTimestamp
    private LocalDateTime writeDate;

    @OneToMany(mappedBy = "board")
    private List<AwsS3> awsS3s;

    @Builder
    public Board(Users users, String description){
        this.users = users;
        this.description = description;
    }

}
