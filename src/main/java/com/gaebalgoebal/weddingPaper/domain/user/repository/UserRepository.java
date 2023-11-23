package com.gaebalgoebal.weddingPaper.domain.user.repository;

import com.gaebalgoebal.weddingPaper.domain.user.dto.UserDrawDto;
import com.gaebalgoebal.weddingPaper.domain.user.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    Users findByUserNameAndCellPhoneNumber(String userName, String cellPhoneNumber);

    @Query(value = "select distinct new com.gaebalgoebal.weddingPaper.domain.user.dto.UserDrawDto(u.userName, u.cellPhoneNumber) from Users u where u.cellPhoneNumber != ''")
    List<UserDrawDto> findDistinctUsers();
}
