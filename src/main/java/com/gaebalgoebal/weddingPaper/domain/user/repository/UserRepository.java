package com.gaebalgoebal.weddingPaper.domain.user.repository;

import com.gaebalgoebal.weddingPaper.domain.user.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    Users findByUserNameAndCellPhoneNumber(String userName, String cellPhoneNumber);

    @Query(value = "select u.user_id, u.user_name, u.cellphone_number from users u group by user_name, cellphone_number", nativeQuery = true)
    List<Users> findDistinctByUserNameAndCellPhoneNumber();
}
