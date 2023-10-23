package com.gaebalgoebal.weddingPaper.domain.user.entity;

import com.gaebalgoebal.weddingPaper.domain.board.entity.Board;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "user_name")
    private String userName;

    @OneToMany(mappedBy = "users")
    private List<Board> boards;

    @Builder
    public Users(String userName){
        this.userName = userName;
    }

}
