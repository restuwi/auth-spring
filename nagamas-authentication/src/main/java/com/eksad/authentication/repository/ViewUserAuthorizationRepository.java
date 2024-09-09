package com.eksad.authentication.repository;

import com.eksad.authentication.domain.ViewUserAuthorization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ViewUserAuthorizationRepository extends JpaRepository<ViewUserAuthorization, String> {
    @Query(value = "SELECT * FROM vw_user_authorization WHERE user_id = :userId", nativeQuery = true)
    List<ViewUserAuthorization> findByUserId(@Param("userId") String userId);
}
