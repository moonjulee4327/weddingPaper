package com.gaebalgoebal.weddingPaper.domain.user.repository;

import com.gaebalgoebal.weddingPaper.domain.user.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
}
