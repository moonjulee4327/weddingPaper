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

    @Column(name = "cellphone_number")
    private String cellPhoneNumber;

    @OneToMany(mappedBy = "users")
    private List<Board> boards;

    @Builder
    public Users(String userName, String cellPhoneNumber){
        this.userName = userName;
        this.cellPhoneNumber = cellPhoneNumber;
    }

}
